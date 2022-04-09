package com.liang.designPattern._01creator.abstractFactory.parts;

public class BetrayGood implements Betray{

    @Override
    public void showBetray() {
        System.out.println("good Betray,一节更比六节强");
    }
}
