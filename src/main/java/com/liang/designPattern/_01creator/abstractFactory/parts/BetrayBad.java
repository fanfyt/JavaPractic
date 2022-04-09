package com.liang.designPattern._01creator.abstractFactory.parts;

public class BetrayBad implements Betray{
    @Override
    public void showBetray() {
        System.out.println("badBetray，不好使");
    }
}
