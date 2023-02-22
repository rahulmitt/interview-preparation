package com.interviewpedia.preparation.corejava._3_multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * <p><b>CountDownLatch</b> is a concurrency construct that allows one or more threads to wait for a given set of operations to complete.
 * Simply put, a CountDownLatch has a <b>counter</b> field, which you can decrement as we require.
 * We can then use it to block a calling thread until it's been <b>counted down to zero</b>.
 * This count is decremented by calls to the <b>countDown()</b> method</p>
 *
 * <p></p>
 * <p>{@code CountDownLatch latch = new CountDownLatch(3);}</p>
 * <p></p>
 *
 * <p>We can instantiate the CountDownLatch with the same value for the counter as a number of threads we want to work across.
 * Then, we could just call <b>countdown()</b> after each thread finishes, guaranteeing that a dependent thread calling
 * <b>await()</b> will be blocked until the worker threads are finished (until the count reaches zero).</p>
 *
 * <p>CountDownLatch can be used to monitor the completion of the Children Threads if the size of the created children is known forehand.
 * CountDownLatch enables a Thread or Threads to wait for completion of Children Threads.
 * But there is no waiting amongst the Children until they finish each others tasks.
 * Children may execute asynchronously and after their work is done will exit making a countdown.</p>
 *
 * <p><b>Practical Example :</b> Main thread creates 10 Database Connections and Creates 10 different Threads and assigns those
 * DB connection to the threads one each. But the Main thread must wait until all 10 Threads finish their DB Operation
 * before closing the DB Connections. Children will exit after performing the DB Operation. A CountDownLatch can be used in this scenario.</p>
 */
public class _4_CountDownLatchExample {
    private static final int COUNT = 5;

    public static void main(String[] args) throws Exception {
        CountDownLatch latch = new CountDownLatch(COUNT);

        System.out.println("Spawning Threads");
        for (int i = 0; i < COUNT; i++) {
            new Worker(latch, String.format("Thread-%d", i));
        }
        System.out.println("Spawning Finished");
        System.out.println("Waiting All Threads to Finish");

        latch.await(); // Await is void
        System.out.println("All Threads are Finished");
    }

    private static class Worker implements Runnable {
        private final CountDownLatch countDownLatch;
        private final String name;
        private static final Random random = new Random();

        public Worker(CountDownLatch countDownLatch, String name) {
            this.name = name;
            this.countDownLatch = countDownLatch;
            new Thread(this).start();
        }

        public void run() {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                System.out.printf("\t%s : Doing Some Work on %s\n", getFormattedDate(sdf), name);
                sleep();
                System.out.printf("\t\t%s : Doing Some more work on %s\n", getFormattedDate(sdf), name);
                sleep();
                System.out.printf("\t%s : Finished work on %s\n", getFormattedDate(sdf), name);

                countDownLatch.countDown();
                System.out.printf("\t%s : Count Down Latch count on %s is %d\n", getFormattedDate(sdf), name, countDownLatch.getCount());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        private String getFormattedDate(SimpleDateFormat sdf) {
            return sdf.format(new Date());
        }

        private void sleep() {
            try {
                Thread.sleep(random.nextInt(5) * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
