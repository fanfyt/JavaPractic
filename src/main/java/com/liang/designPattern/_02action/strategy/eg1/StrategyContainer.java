package com.liang.designPattern._02action.strategy.eg1;

import com.liang.designPattern._02action.strategy.eg1.s.StragegyInter;

//策略容器类
public class StrategyContainer {
    //定义策略接口对象
    private StragegyInter stragegyInter;

    //定义策略容器的构造函数
    public StrategyContainer(StragegyInter stragegyInter) {
        this.stragegyInter = stragegyInter;
    }

    //定义调用的方法
    public void operate(){
        //通过接口对象调用指定方法
        this.stragegyInter.operate();
    }
}
