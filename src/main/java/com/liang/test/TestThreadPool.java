package com.liang.test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestThreadPool {


    static ThreadPoolExecutor executor1  =
            new ThreadPoolExecutor(
                    1,
                    3,
                    2,
                    SECONDS,
                    new ArrayBlockingQueue(2) ,
                    Executors.defaultThreadFactory(),
                    (r, executor1) -> System.out.println("已拒绝"));

    public static void main(String[] args) {
        AtomicInteger a= new AtomicInteger();

        for (int i = 0;i<10;i++){
            executor1.execute(()->{
                a.getAndIncrement();
                String name = Thread.currentThread().getName();
                System.out.println(name+"        任务"+a);
            });
        }



    }
}
