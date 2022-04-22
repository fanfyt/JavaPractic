package com.juc.lockit;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockTest {

    private static ReentrantLock lock = new ReentrantLock();
    private static int i = 0;
    private static final int THREAD_NUM =1000;
    private static CountDownLatch countDownLatch =  new CountDownLatch(THREAD_NUM);

    public static void main(String[] args) throws InterruptedException {
        for (int j =0;j<THREAD_NUM;j++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    lock.lock();
                    try {
                        for (int k=0;k<10;k++){
                            i++;
                        }
                    }catch (Exception e){

                    }finally {
                        lock.unlock();
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("i = " + i);

    }

}
