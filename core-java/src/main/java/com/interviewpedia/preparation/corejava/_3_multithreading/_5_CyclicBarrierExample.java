package com.interviewpedia.preparation.corejava._3_multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * <p>A <b>CyclicBarrier</b> is a synchronizer that allows a set of threads to wait for each other to reach a common
 * execution point, also called a <b>barrier</b>. The barrier is called cyclic because it can be re-used after the waiting
 * threads are released.</p>
 *
 * <p></p>
 * <p>{@code public CyclicBarrier(int parties)}</p>
 * <p></p>
 *
 * <p>The threads (parties) that need to synchronize their execution invoke the <b>await()</b> method to register that
 * a certain thread has reached the barrier point.</p>
 *
 * <p></p>
 * <p>{@code CyclicBarrier barrier = new CyclicBarrier(2);}</p>
 * <p>{@code barrier.await();}</p>
 * <p></p>
 *
 * <p>This call is synchronous and the thread calling this method suspends execution till a specified number of
 * threads have invoked the same method on the barrier. This situation where the required number of threads have
 * called await(), is called <b>tripping the barrier</b>.</p>
 *
 * <p>Optionally, we can pass the second argument to the constructor, which is a <b>Runnable instance</b>. This has logic
 * that would be run by the last thread that trips the barrier:</p>
 *
 * <p></p>
 * <p>{@code public CyclicBarrier(int parties, Runnable barrierAction)}</p>
 * <p></p>
 *
 *
 * <p>CyclicBarrier can be used to create a set of parties if their count is known forehand.
 * CyclicBarrier can be used to implement waiting amongst party-threads until all of them finish.
 * This is useful where parallel threads needs to perform a job which requires sequential execution.
 * For example 10 Threads doing steps 1, 2, 3 but all 10 Threads should finish step one before any can do step 2.
 * Cyclic barrier can be reset after all Threads are finished execution. This is a distinguishing feature from a CountDownLatch.
 * A CountDownLatch can only be used for a single count down.
 * Additionally a CyclicBarrier can be assigned an Additional Thread which executes each time all the
 * Children Threads finish their respective tasks.</p>
 *
 * <p><b>Practical Example :</b> Processing of a Image Pixels Matrix row by row in the first step and in the second step
 * saving the Pixel values to file row by row. In this scenario if there are 10 Threads running simultaneously to
 * process the matrix row by row then all 10 should wait until all are finished before they move on to the next
 * step which is saving those rows to file.</p>
 */
public class _5_CyclicBarrierExample {
    private static final int PARTY_COUNT = 5;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(PARTY_COUNT, new BarrierAction());

        System.out.println("Spawning Threads");
        for (int i = 0; i < PARTY_COUNT; i++) {
            new Party(cyclicBarrier, String.format("Thread-%d", i));
        }
        System.out.println("Spawning Finished");
    }

    private static class BarrierAction implements Runnable {
        private int count = 1;

        public void run() {
            System.out.printf("Cyclic Barrier Finished %d\n", count++);
        }
    }

    private static class Party implements Runnable {
        private final CyclicBarrier cyclicBarrier;
        private final String name;
        private static final Random random = new Random();

        public Party(CyclicBarrier cyclicBarrier, String name) {
            this.name = name;
            this.cyclicBarrier = cyclicBarrier;
            new Thread(this).start();
        }

        public void run() {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                System.out.printf("\t\t%s : Doing Step 1 Work on %s\n", getFormattedDate(sdf), name);
                sleep();
                System.out.printf("\t\t%s : Doing Step 1 more work on %s\n", getFormattedDate(sdf), name);
                sleep();
                System.out.printf("\t\t%s : Finished Step 1 work on %s\n", getFormattedDate(sdf), name);

                int count = cyclicBarrier.await(); // Await returns an int which is the arrival index 1 means first 0 means last
                System.out.printf("\t%s : Cyclic Barrier count on %s is %d\n", getFormattedDate(sdf), name, count);
                if (count == 0) {
                    cyclicBarrier.reset();
                }

                System.out.printf("\t\t%s : Doing Step 2 Batch of Work on %s\n", getFormattedDate(sdf), name);
                sleep();
                System.out.printf("\t\t%s : Doing Some more Step 2 Batch of work on %s\n", getFormattedDate(sdf), name);
                sleep();
                System.out.printf("\t\t%s : Finished Step 2 Batch of work on %s\n", getFormattedDate(sdf), name);

                count = cyclicBarrier.await();
                System.out.printf("\t%s : Cyclic Barrier count end of Step 2 Batch of work on %s is %d\n", getFormattedDate(sdf), name, count);

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
