package com.liang.designPattern._01creator.singleTon;

//利用枚举类实现，枚举类型本身就是单例的
public enum EnumTypeClass {

    /**
     *
     */
    E;
    String s(){
        String a ="123";
        return  a;
    }

    //测试
    public static void main(String[] args) {

        for (int i = 0; i <90 ; i++) {
            new Thread(()->{
                System.out.println(EnumTypeClass.E.s().hashCode());
            }).start();
        }
    }


}
