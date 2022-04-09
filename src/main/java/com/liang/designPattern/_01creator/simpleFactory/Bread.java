package com.liang.designPattern._01creator.simpleFactory;

public class Bread implements Food {
    @Override
    public Food zuofan() {
        System.out.println("做一个面包");
        //返回一个产品对象
        return new Bread();
    }
}
