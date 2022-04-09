package com.liang.designPattern._01creator.singleTon;


//(因为JVM本质重排序的原因，可能会初始化多次，不推荐使用)
//双重检测锁模式
public class DoubleCheck {
    //构造方法
    public DoubleCheck() {
    }
    //声明对象为静态对象
    private static DoubleCheck doubleCheck;
    //静态方法返回单例的初始化对象，先判断是否为空，为空则进行初始化，需要对类加锁
    public static DoubleCheck getDoubleCheck() {

        if (doubleCheck == null){
            //给类资源加锁
            synchronized (DoubleCheck.class){
                doubleCheck = new DoubleCheck();
            }
        }
        return doubleCheck;
    }

    public static void main(String[] args) {
        DoubleCheck doubleCheck = DoubleCheck.getDoubleCheck();
        DoubleCheck doubleCheck1 = DoubleCheck.getDoubleCheck();
        System.out.println(doubleCheck==doubleCheck1);
    }
}
