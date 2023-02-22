package com.interviewpedia.preparation.corejava._3_multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class _3_ProducerConsumerUsingBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(10);
        new Producer(buffer);
        new Consumer(buffer);
        new Consumer(buffer);
    }

    private static class Producer implements Runnable {
        private BlockingQueue<Integer> buffer;
        private static final Random random = new Random();

        public Producer(BlockingQueue<Integer> buffer) {
            this.buffer = buffer;
            new Thread(this).start();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    int data = random.nextInt(1000);
                    System.out.println("ENQUEUE: " + data);
                    buffer.put(data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Consumer implements Runnable {
        private BlockingQueue<Integer> buffer;
        private static final Random random = new Random();

        public Consumer(BlockingQueue<Integer> buffer) {
            this.buffer = buffer;
            new Thread(this).start();
        }

        @Override
        public void run() {
            try {
                int data = buffer.take();
                System.out.println("\t\tDEQUEUE: " + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
