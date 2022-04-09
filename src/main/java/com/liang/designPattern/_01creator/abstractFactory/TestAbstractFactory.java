package com.liang.designPattern._01creator.abstractFactory;

import com.liang.designPattern._01creator.abstractFactory.parts.CPU;

//抽象工厂模式
public class TestAbstractFactory {
    public static void main(String[] args) {
        FactoryInterface huaWeiFactory = new HuaWeiFactory();
        FactoryInterface appleFactory = new AppleFactory();

        CPU qinLingCPU =  huaWeiFactory.createCPU();
        CPU A15 = appleFactory.createCPU();

        qinLingCPU.showCPU();
        A15.showCPU();
    }
}
