package com.liang.designPattern._01creator.abstractFactory;

import com.liang.designPattern._01creator.abstractFactory.parts.Betray;
import com.liang.designPattern._01creator.abstractFactory.parts.CPU;

//抽象工厂模式
public class TestAbstractFactory {
    public static void main(String[] args) {
        //通过创建不同工厂对象，然后再创建不同的产品对象

        FactoryInterface huaWeiFactory = new HuaWeiFactory();
        FactoryInterface appleFactory = new AppleFactory();

        CPU qinLingCPU =  huaWeiFactory.createCPU();
        Betray betray =  huaWeiFactory.createBetray();
        CPU A15 = appleFactory.createCPU();

        qinLingCPU.showCPU();
        A15.showCPU();
        betray.showBetray();
    }
}
