package com.interviewpedia.preparation.corejava._3_multithreading;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class _9_CustomThreadPool {
    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool(4);
        try {
            threadPool.execute(new Task());
            threadPool.execute(new Task());
            threadPool.execute(new Task());
            threadPool.execute(new Task());
            threadPool.execute(new Task());
            threadPool.execute(new Task());
            threadPool.execute(new Task());
            threadPool.execute(new Task());
            threadPool.execute(new Task());
            threadPool.execute(new Task());
        } finally {
            threadPool.shutdown();
        }
    }

    private static class ThreadPool {
        private final int poolSize;
        private final WorkerThread[] workerThreads;
        private final BlockingQueue<Runnable> runnableQueue;

        public ThreadPool(int poolSize) {
            this.poolSize = poolSize;
            workerThreads = new WorkerThread[poolSize];
            runnableQueue = new LinkedBlockingQueue<>();

            for (int i = 0; i < poolSize; i++) {
                workerThreads[i] = new WorkerThread(runnableQueue);
                workerThreads[i].start();
            }
        }

        public void execute(Runnable runnable) {
            try {
                runnableQueue.put(runnable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void shutdown() {
            while (runnableQueue.size() !=0) {};
            Arrays.stream(workerThreads).forEach(WorkerThread::shutdown);
        }
    }

    private static class WorkerThread extends Thread {
        private boolean alive = true;
        private final BlockingQueue<Runnable> runnableQueue;

        public WorkerThread(BlockingQueue<Runnable> blockingQueue) {
            this.runnableQueue = blockingQueue;
        }

        public void shutdown() {
            alive = false;
        }

        @Override
        public void run() {
            super.run();
            while (alive) {
                try {
                    Runnable runnable = runnableQueue.poll(100, TimeUnit.MILLISECONDS);
                    if(runnable != null) runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Task implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getId() + " :: Task started");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getId() + " :: Task completed");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
