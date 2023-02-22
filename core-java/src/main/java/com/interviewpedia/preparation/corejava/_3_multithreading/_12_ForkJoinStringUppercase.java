package com.interviewpedia.preparation.corejava._3_multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * <p>The <b>java.util.concurrent.ForkJoinPool</b> is similar to the <b>ExecutorService</b> but with one difference. The ForkJoinPool makes it easy for
 * tasks to split their work up into smaller tasks which are then submitted to the ForkJoinPool too</p>
 *
 * <p>Tasks can keep splitting their work into smaller subtasks for as long as it makes to split up the task. The limit
 * for when it makes sense to fork a task into subtasks is also called a <b>threshold</b></p>
 *
 * <p>The <b>fork</b> and <b>join</b> principle consists of two steps which are performed recursively:<br/>
 * 1. Fork step — tasks split themselves into smaller subtasks which can be executed in parallel by different CPU, or different threads on the same CPU<br/>
 * 2. Join step — Once the subtasks have finished executing, the task may merge all the results into one result.
 * If the tasks do not return a result then a task just waits for its subtasks to complete. No result merging takes place then</p>
 *
 * <p>As a parameter to the ForkJoinPool constructor you pass the indicated level of parallelism you desire.
 * The <b>parallelism level</b> indicates how many threads or CPUs you want to work concurrently on on tasks passed to the ForkJoinPool</p>
 *
 * <p></p>
 * <p>{@code ForkJoinPool forkJoinPool = new ForkJoinPool(4);}</p>
 * <p></p>
 *
 * <p>You can submit two types of tasks:<br/>
 * 1. <b>RecursiveAction — </b>a task which does not return any value. It just does some work, e.g. writing data to disk, and then exits.<br/>
 * 2. <b>RecursiveTask — </b>a task that returns a result. It may split its work up into smaller tasks, and merge the result of these smaller tasks into a collective result.</p>
 *
 * <p>Further reading: https://medium.com/swlh/the-unfairly-unknown-forkjoinpool-c262777def6a</p>
 */
public class _12_ForkJoinStringUppercase {

    public static void main(String[] args) {
        List<String> input = Arrays.asList("rahul", "neha", "tushar", "reyansh", "nitara");
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        try {
            List<String> output = forkJoinPool.invoke(new UppercaseRecursiveTask(input));
            System.out.println(output);

            forkJoinPool.invoke(new UppercaseRecursiveAction(input));
        }finally {
            forkJoinPool.shutdown();
        }
    }

    private static class UppercaseRecursiveAction extends RecursiveAction {
        private final List<String> input;

        public UppercaseRecursiveAction(List<String> input) {
            this.input = input;
        }

        @Override
        protected void compute() {
            if(input.size() == 0) return;
            else if (input.size() == 1) System.out.print(input.get(0).toUpperCase() + ", ");
            else {
                int mid = input.size()/2;
                new UppercaseRecursiveAction(input.subList(0, mid)).fork();
                new UppercaseRecursiveAction(input.subList(mid, input.size())).fork();
            }
        }
    }

    private static class UppercaseRecursiveTask extends RecursiveTask<List<String>> {
        private final List<String> input;

        public UppercaseRecursiveTask(List<String> input) {
            this.input = input;
        }

        @Override
        protected List<String> compute() {
            if (input.size() == 0) {
                return Collections.emptyList();
            } else if (input.size() == 1) {
                return Collections.singletonList(input.get(0).toUpperCase());
            } else {
                int mid = input.size() / 2;
                ForkJoinTask<List<String>> left = new UppercaseRecursiveTask(input.subList(0, mid)).fork();
                ForkJoinTask<List<String>> right = new UppercaseRecursiveTask(input.subList(mid, input.size())).fork();

                List<String> output = new ArrayList<>();
                output.addAll(left.join());
                output.addAll(right.join());
                return output;
            }
        }
    }
}
