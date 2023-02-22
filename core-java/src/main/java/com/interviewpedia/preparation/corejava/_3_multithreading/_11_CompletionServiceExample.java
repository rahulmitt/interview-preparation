package com.interviewpedia.preparation.corejava._3_multithreading;

import java.util.Random;
import java.util.concurrent.*;

/**
 *
 *
 * https://stackoverflow.com/a/5580058
 */
public class _11_CompletionServiceExample {

    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(fixedThreadPool);
        try {
            submit(completionService, "fixedThreadPool", 10);
        } finally {
            fixedThreadPool.shutdown();
        }
    }

    private static void submit(CompletionService<Integer> completionService, String taskName, int taskCount) {
        for (int i = 0; i < taskCount; i++) {
            completionService.submit(new _11_CompletionServiceExample.Task(taskName));
        }

        for (int i = 0; i < taskCount; i++) {
            try {
                System.out.println(completionService.take().get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    private static class Task implements Callable<Integer> {
        private final String taskName;
        private static final Random random = new Random();

        public Task(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public Integer call() throws Exception {
            int i = 0;
            int max = random.nextInt(5);
            while (i < max) {
                Thread.sleep(1000);
                System.out.printf("%s :: %d :: Subtask %d completed\n", taskName, Thread.currentThread().getId(), i);
                i++;
            }
            return max;
        }
    }
}
