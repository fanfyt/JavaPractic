package com.juc.atomic;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    private static Integer a = new Integer(0);
    private static Integer b = new Integer(0);
    private static AtomicInteger c = new AtomicInteger(0);

    private static final int THREAD_NUM = 1000;
    private static CountDownLatch latchOne = new CountDownLatch(THREAD_NUM);
    private static CountDownLatch latchTwo = new CountDownLatch(THREAD_NUM);
    private static CountDownLatch latchThree = new CountDownLatch(THREAD_NUM);

    public static void main(String[] args) throws InterruptedException {
        useThreadTwo();
        useThreadOne();
        useThreadThree();
    }

    private static void useThreadOne() throws InterruptedException {
        long start = System.currentTimeMillis();
        ThreadOne threadOne = new ThreadOne();
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(threadOne).start();
        }
        latchOne.await();
        long end = System.currentTimeMillis();
        System.out.println("normal: a => time = " + (end - start) + " ms" + ", result = " + a);
    }

    static class ThreadOne implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                a++;
            }
            latchOne.countDown();
        }
    }

    private static void useThreadTwo() throws InterruptedException {
        long start = System.currentTimeMillis();
        ThreadTwo threadTwo = new ThreadTwo();
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(threadTwo).start();
        }
        latchTwo.await();
        long end = System.currentTimeMillis();
        System.out.println("synchronized: b => time = " + (end - start) + " ms" + ", result = " + b);
    }

    static class ThreadTwo implements Runnable {

        @Override
        public void run() {
            synchronized (this) {
                for (int i = 0; i < 1000; i++) {
                    b++;
                }
                latchTwo.countDown();
            }
        }
    }

    private static void useThreadThree() throws InterruptedException {
        long start = System.currentTimeMillis();
        ThreadThree threadThree = new ThreadThree();
        for (int i = 0; i < THREAD_NUM; i++) {
            new Thread(threadThree).start();
        }
        latchThree.await();
        long end = System.currentTimeMillis();
        System.out.println("AtomicInteger: c => time = " + (end - start) + " ms" + ", result = " + c);
    }

    static class ThreadThree implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                c.incrementAndGet();
            }

            latchThree.countDown();
        }
    }

}