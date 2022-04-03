package com.liang.designPattern._01creator.singleTon;

//饿汉式:类初始化时,会立即加载该对象，线程天生安全,调用效率高。

import jdk.swing.interop.SwingInterOpUtils;

public class Ehanshi {

    //直接初始化一个静态私有类对象
    private static Ehanshi 饿汉= new Ehanshi();

    public Ehanshi() {
    }

    //调用时直接返回
    public static Ehanshi getInstance(){
        return 饿汉;
    }

    public static void main(String[] args) {
        Ehanshi 饿汉1 = Ehanshi.getInstance();
        Ehanshi 饿汉2 = Ehanshi.getInstance();
        System.out.println(饿汉1 == 饿汉2);
    }
}
