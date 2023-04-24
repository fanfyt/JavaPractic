package com.threadPractice.basic.test1;

public class TestThread {
    public static void main(String[] args) {

        Thread.currentThread().setName("主线程");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }

        Athread athread = new Athread();
        athread.setName("子线程");
        athread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }

    }

}
