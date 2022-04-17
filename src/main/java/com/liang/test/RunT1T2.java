package com.liang.test;

public class RunT1T2 implements  Runnable{
    private int a=0;
    private int b=0;
    boolean flag=true;

    public static void main(String[] args) {
        RunT1T2 r1=new RunT1T2();
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r1);
        t1.start();
        t2.start();

    }

    @Override
    public void run() {
        while(flag){
            a++;b++;
            System.out.println( a==b?true:"............");
            if (a>=1000000){
                System.out.println("a===="+a);
                flag=false;
            }
        }
    }
}
