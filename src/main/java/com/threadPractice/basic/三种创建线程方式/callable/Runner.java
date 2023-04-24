package com.threadPractice.basic.三种创建线程方式.callable;

import java.util.concurrent.Callable;

public class Runner implements Callable<Integer> {

    @Override
    public Integer call() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
        return null;
    }
}
