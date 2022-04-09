package com.liang.designPattern._01creator.abstractFactory;

import com.liang.designPattern._01creator.abstractFactory.parts.*;

public class HuaWeiFactory implements FactoryInterface{

    @Override
    public CPU createCPU() {
        return new QinLingCPU();
    }

    @Override
    public Betray createBetray() {
        return new BetrayGood();
    }

    @Override
    public PingMu createPingMu() {
        return createPingMu();
    }

}
