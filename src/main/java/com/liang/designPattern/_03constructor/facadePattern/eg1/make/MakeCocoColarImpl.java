package com.liang.designPattern._03constructor.facadePattern.eg1.make;

public class MakeCocoColarImpl implements MakeCocoColar{
    @Override
    public void takeCup() {
        System.out.println("正在取杯子");
    }

    @Override
    public void takeCocoColar() {
        System.out.println("正在拿可乐");
    }

    @Override
    public void pourInCup() {
        System.out.println("正在把可乐倒进杯子");
    }
}
