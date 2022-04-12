package com.liang.designPattern._02action.strategy.eg1;

import com.liang.designPattern._02action.strategy.eg1.s.Strategy01;

//策略类的使用者
public class User {
    public static void main(String[] args) {
        //声明一个策略容器类，在初始化实例的时候在参数中指定要使用的策略
        StrategyContainer strategy = new StrategyContainer(new Strategy01());

        //调用初始化对象
        strategy.operate();
    }
}
