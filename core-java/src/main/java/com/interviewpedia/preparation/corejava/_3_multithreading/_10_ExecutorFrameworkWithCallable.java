package com.interviewpedia.preparation.corejava._3_multithreading;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

public class _10_ExecutorFrameworkWithCallable {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        try {
            submit(singleThreadExecutor, "singleThreadExecutor", 10);
            submit(fixedThreadPool, "fixedThreadPool", 10);
            submit(cachedThreadPool, "cachedThreadPool", 20);
            schedule(scheduledThreadPool, "scheduledThreadPool", 5, 5);
        } finally {
            singleThreadExecutor.shutdown();
            fixedThreadPool.shutdown();
            cachedThreadPool.shutdown();
            scheduledThreadPool.shutdown();
        }
    }

    private static void submit(ExecutorService executorService, String taskName, int taskCount) {
        Future[] futures = new Future[taskCount];
        for (int i = 0; i < taskCount; i++) {
            futures[i] = executorService.submit(new CallableTask(taskName));
        }
        Arrays.stream(futures).forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    private static void schedule(ScheduledExecutorService scheduledThreadPool, String taskName, long delaySeconds, int taskCount) {
        ScheduledFuture[] futures = new ScheduledFuture[taskCount];
        for (int i = 0; i < taskCount; i++) {
            futures[i] = scheduledThreadPool.schedule(new CallableTask(taskName), delaySeconds, TimeUnit.SECONDS);
        }
        Arrays.stream(futures).forEach(f -> {
            try {
                System.out.println(f.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

    }

    private static class CallableTask implements Callable<Integer> {
        private final String taskName;
        private static final Random random = new Random();

        public CallableTask(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public Integer call() throws Exception {
            int i=0;
            int max = random.nextInt(5);
            while (i<max) {
//                System.out.printf("%s :: %d :: Subtask started %d\n", taskName, Thread.currentThread().getId(), i);
                Thread.sleep(1000);
                System.out.printf("%s :: %d :: Subtask %d completed\n", taskName, Thread.currentThread().getId(), i);
                i++;
            }
            return max;
        }
    }
}
