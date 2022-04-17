package com.liang.test;

public class TestCount {
    public static int count =0;
    public static void main(String[] args) {
        for (int i = 0; i <1000 ; i++) {
            Thread t = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    count++;
                }
            }
            );
            t.start();
        }
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(count);
    }
}
