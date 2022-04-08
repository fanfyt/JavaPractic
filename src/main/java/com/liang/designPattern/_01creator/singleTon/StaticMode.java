package com.liang.designPattern._01creator.singleTon;
//静态内部类
// 静态内部方式:结合了懒汉式和饿汉式各自的优点，真正需要对象的时候才会加载，加载类是线程安全的。
public class StaticMode {

    //构造方法
    private StaticMode(){}
    //静态内部类
    private static class StaticModeInsance{
        private static final StaticMode demo = new StaticMode();
    }
    //get方法:返回静态内部类的实例
    public static StaticMode getInstance(){
        return  StaticModeInsance.demo;
    }

    //test
    public static void main(String[] args) {
        StaticMode s1  = StaticMode.getInstance();
        StaticMode s2  = StaticMode.getInstance();
        System.out.println(s1==s2);
    }

}
