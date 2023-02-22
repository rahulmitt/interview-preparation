package com.interviewpedia.preparation.corejava._3_multithreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class _2_ProducerConsumer {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        new Producer(buffer);
        new Consumer(buffer);
    }

    private static class Buffer {
        private static final int MAX_SIZE = 10;

        private final List<Integer> queue = new LinkedList<>();

        public synchronized void put(int data) throws InterruptedException {
            while (queue.size() == MAX_SIZE) wait(500);

            queue.add(data);
            notifyAll();
        }

        public synchronized Integer get() throws InterruptedException {
            while (queue.size() == 0) wait(500);

            Integer data = queue.remove(0);
            notifyAll();
            return data;
        }
    }

    private static class Producer implements Runnable {
        private final Buffer buffer;
        private static final Random random = new Random();

        public Producer(Buffer buffer) {
            this.buffer = buffer;
            new Thread(this).start();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(random.nextInt(2) * 1000);
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
        private final Buffer buffer;
        private static final Random random = new Random();

        public Consumer(Buffer buffer) {
            this.buffer = buffer;
            new Thread(this).start();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Integer data = buffer.get();
                    System.out.println("\t\tDEQUEUE: " + data);
                    Thread.sleep(random.nextInt(2) * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
