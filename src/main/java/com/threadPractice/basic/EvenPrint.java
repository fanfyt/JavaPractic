package com.threadPractice.basic;

import java.util.concurrent.Callable;

//实现两个线程交替执行，使用Object的wait/notify方法
public class EvenPrint implements Runnable  {
    Integer a= 100;
    public static void main(String[] args) throws InterruptedException {
        EvenPrint  evenPrint = new EvenPrint();
        Thread t1 = new Thread( evenPrint);
        Thread t2 = new Thread( evenPrint);
        t2.start();
        t1.start();
//        new Thread(evenPrint).start();
//        new Thread(evenPrint).start();

    }


    @Override
    public void run() {
        synchronized (this) {
            while (this.a > 0) {
                notify();
                if (a % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + this.a);
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                a--;
            }

        }
    }
}
