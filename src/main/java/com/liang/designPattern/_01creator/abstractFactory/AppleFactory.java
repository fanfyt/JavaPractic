package com.liang.designPattern._01creator.abstractFactory;

import com.liang.designPattern._01creator.abstractFactory.parts.*;

public class AppleFactory implements FactoryInterface{
    @Override
    public CPU createCPU() {
        return new A15CPU();
    }

    @Override
    public Betray createBetray() {
        return new BetrayBad();
    }

    @Override
    public PingMu createPingMu() {
        return null;
    }
}
