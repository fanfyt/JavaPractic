package com.liang.designPattern._01creator.simpleFactory;

public class ManTou implements Food {

    @Override
    public Food zuofan() {
        System.out.println("做一个馒头");
        return new ManTou();
    }
}
