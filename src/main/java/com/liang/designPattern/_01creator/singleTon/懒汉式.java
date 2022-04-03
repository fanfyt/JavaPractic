package com.liang.designPattern._01creator.singleTon;

public class 懒汉式 {

    private static 懒汉式 懒汉;

    public 懒汉式() {
    }
    public synchronized 懒汉式 get懒汉(){
        if (懒汉 == null){
            懒汉 = new 懒汉式();
        }
        return 懒汉;
    }

    public static void main(String[] args) {
        懒汉式 懒汉1 = 懒汉式.懒汉;
    }
}
