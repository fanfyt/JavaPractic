package com.juc.atomic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest2 {
    private static AtomicInteger  atomicInteger= new AtomicInteger(0);

    ThreadLocal threadLocal = new ThreadLocal();
    public static void main(String[] args) {
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        list2.add(1);
        for (int i=0;i<10000; i++){

            new Thread(
                    ()->{
                        list1.add(atomicInteger.getAndIncrement());
//                        System.out.println( Thread.currentThread().getName()+"  a:"+atomicInteger.get());
                    }
            ).start();

        }

        System.out.println(list1.size());
        list1.stream().forEach(System.out::println);
        System.out.println("size: "+list1.size());

        System.out.println(list2);
    }
}
