package com.interviewpedia.preparation.corejava._3_multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class _8_ExecutorFrameworkWithRunnable {
    public static void main(String[] args) {
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        try {
            execute(singleThreadExecutor, "singleThreadExecutor", 10);
            execute(fixedThreadPool, "fixedThreadPool", 10);
            execute(cachedThreadPool, "cachedThreadPool", 20);
            schedule(scheduledThreadPool, "scheduledThreadPool", 5, 5);
        } finally {
            singleThreadExecutor.shutdown();
            fixedThreadPool.shutdown();
            cachedThreadPool.shutdown();
            scheduledThreadPool.shutdown();
        }
    }

    private static void execute(ExecutorService executorService, String taskName, int taskCount) {
        for (int i = 0; i < taskCount; i++) {
            executorService.execute(new RunnableTask(taskName));
        }
    }

    private static void schedule(ScheduledExecutorService scheduledThreadPool, String taskName, long delaySeconds, int taskCount) {
        for (int i = 0; i < taskCount; i++) {
            scheduledThreadPool.schedule(new RunnableTask(taskName), delaySeconds, TimeUnit.SECONDS);
        }
    }

    private static class RunnableTask implements Runnable {
        private String taskName;

        public RunnableTask(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            try {
                System.out.println(taskName + " :: " + Thread.currentThread().getId() + " :: Task started");
                Thread.sleep(1000);
                System.out.println(taskName + " :: " + Thread.currentThread().getId() + " :: Task completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
