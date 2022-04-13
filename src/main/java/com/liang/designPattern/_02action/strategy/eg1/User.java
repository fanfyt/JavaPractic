package com.liang.designPattern._02action.strategy.eg1;

import com.liang.designPattern._02action.strategy.eg1.s.Strategy01;
import com.liang.designPattern._02action.strategy.eg1.s.Strategy02;
import com.liang.designPattern._02action.strategy.eg1.s.Strategy03;

//策略类的使用者
public class User {

    public static void main(String[] args) {
        //声明一个策略容器类，在初始化实例的时候在参数中指定要使用的策略
        StrategyContainer strategy1 = new StrategyContainer(new Strategy01());
        StrategyContainer strategy2 = new StrategyContainer(new Strategy02());
        StrategyContainer strategy3 = new StrategyContainer(new Strategy03());
        //通过策略容器对象中的接口调用初始化方法
        strategy1.operate();
        strategy2.operate();
        strategy3.operate();
    }
}
