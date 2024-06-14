package com.dvb.practice.concurrencydeadlock;

import java.time.Duration;
import java.time.Instant;

public class ConcurrencyDeadLock {

    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();

        Object objectA = new Object();
        Object objectB = new Object();
        Object objectC = new Object();

        ConcurrencyDeadLock concurrencyDeadLock = new ConcurrencyDeadLock();

        Thread threadA = new Thread(concurrencyDeadLock.new SyncThread(objectA, objectB), "ThreadA");
        Thread threadB = new Thread(concurrencyDeadLock.new SyncThread(objectB, objectC), "ThreadB");
        Thread threadC = new Thread(concurrencyDeadLock.new SyncThread(objectC, objectA), "ThreadC");

        threadA.start();
        Thread.sleep(5000);
        threadB.start();
        Thread.sleep(5000);
        threadC.start();

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time Elapsed: " + timeElapsed + " milliseconds");
    }

    class SyncThread implements Runnable {

        private Object object1;
        private Object object2;

        public SyncThread(Object object1, Object object2) {
            this.object1 = object1;
            this.object2 = object2;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();

            System.out.println(name + " acquiring lock on " + object1);
            synchronized (object1) {
                System.out.println(name + " acquired lock on " + object1);
                work();
                System.out.println(name + " acquiring lock on " + object2);
                synchronized (object2) {
                    System.out.println(name + " acquired lock on " + object2);
                    work();
                }
                System.out.println(name + " released lock on " + object2);
            }
            System.out.println(name + " released lock on " + object1);
            System.out.println(name + " finished execution.");
        }

        private void work() {
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
