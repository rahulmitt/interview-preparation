package com.interviewpedia.preparation.corejava._3_multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * <p><b>java.util.concurrent.Semaphore</b> is a counting semaphore, i.e., it has two main methods:<br/>
 * 1. acquire()<br/>
 * 2. release()
 * </p>
 *
 * <p>The counting semaphore is initialized with a given number of <b>permits</b>. For each call to <b>acquire()</b> a
 * permit is taken by the calling thread. For each call to <b>release()</b> a permit is returned to the semaphore.
 * Thus, at most N threads can pass the acquire() method without any release() calls, where N is the number of permits
 * the semaphore was initialized with. The permits are just a simple counter.</p>
 *
 * <p>Semaphores typically has two uses:<br/>
 * 1. To guard a critical section against entry by more than N threads at a time. <br/>
 * 2. To send signals between two threads.</p>
 *
 * <p>Semaphore can be used to create a set of Children Threads even when the size of the Threads to be created is not known beforehand.
 * This is because a Semaphore can wait until a number of releases have been made but that number is not required to initialize the Semaphore.
 * Semaphores can be used in other scenarios such as Synchronizing between different threads such as Publisher, Subscriber scenario.</p>
 *
 * <p>No guarantees are made about <b>fairness</b> of the threads acquiring permits from the Semaphore, i.e., there is
 * no guarantee that the first thread to call acquire() is also the first thread to obtain a permit.
 * If the first thread is blocked waiting for a permit, then a second thread checking for a permit just as a permit is released,
 * may actually obtain the permit ahead of thread 1.</p>
 *
 * <p>If you want to enforce fairness, the Semaphore class has a constructor that takes a boolean telling if the semaphore
 * should enforce fairness. Enforcing fairness comes at a performance/concurrency-penalty, so don't enable it unless you need it.</p>
 *
 * <p></p>
 * <p>{@code Semaphore semaphore = new Semaphore(1, true);}</p>
 * <p></p>
 *
 * <p><b>Practical Example :</b> Traversing through a folder with sub folders within sub folders and if JPEG files are found,
 * move them to a destination directory and then zip them. In this scenario the folder traversing is done recursively
 * until a JPEG file is found. And then a Thread is invoked to move it to destination directory. But zipping needs to wait
 * until all JPEG files are moved to the destination directory. In this scenario, the count of JPEG files available in the
 * folder structure is not known but the zipping needs to wait till all files are successfully moved. Ideal scenario for
 * a Semaphore based waiting.</p>
 */
public class _6_SemaphoreExample {
    private static final int MAX_THREADS = 5;

    public static void main(String[] args) throws Exception {
        Semaphore semaphore = new Semaphore(0);
        System.out.println("Spawning Threads");
        int threadCount = 0;
        Random random = new Random();

        for(int i=0;i<MAX_THREADS;i++) {
            // Threads created will not always be MAX_THREADS
            // Because Threads are created only if Random no is Even.
            // Thus the No of Threads unknown at Semaphore Initialization
            if(random.nextInt(9999) % 2 == 0) {
                new Worker(semaphore, String.format("Thread-%d", i));
                threadCount++;
            }
        }
        System.out.println("Spawning Finished");
        System.out.println("Waiting All Threads to Finish");
        semaphore.acquire(threadCount);
        System.out.println("All Threads are Finished");
    }

    private static class Worker implements Runnable {
        private final Semaphore semaphore;
        private final String name;
        private static final Random random = new Random();

        public Worker(Semaphore semaphore, String name) {
            this.name = name;
            this.semaphore = semaphore;
            new Thread(this).start();
        }

        public void run() {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                System.out.printf("\t%s : Doing Some Work on %s\n", getFormattedDate(sdf), name);
                sleep();
                System.out.printf("\t\t\t%s : Doing Some more work on %s\n", getFormattedDate(sdf), name);
                sleep();
                System.out.printf("\t%s : Finished work on %s\n", getFormattedDate(sdf), name);

                semaphore.release();
            } catch(Exception e) {
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
