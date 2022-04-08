package com.liang.designPattern._01creator.singleTon;


//(因为JVM本质重排序的原因，可能会初始化多次，不推荐使用)
//双重检测锁模式
public class DoubleCheck {
    public DoubleCheck() {
    }
    private static DoubleCheck doubleCheck;

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
