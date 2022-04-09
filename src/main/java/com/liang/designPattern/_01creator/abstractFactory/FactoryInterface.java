package com.liang.designPattern._01creator.abstractFactory;

import com.liang.designPattern._01creator.abstractFactory.parts.Betray;
import com.liang.designPattern._01creator.abstractFactory.parts.CPU;
import com.liang.designPattern._01creator.abstractFactory.parts.PingMu;

public interface FactoryInterface {
    CPU createCPU();
    Betray createBetray();
    PingMu createPingMu();
}
