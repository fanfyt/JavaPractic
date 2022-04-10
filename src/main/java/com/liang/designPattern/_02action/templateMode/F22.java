package com.liang.designPattern._02action.templateMode;

public class F22 extends Plane{
    @Override
    public String getName() {
        System.out.println("飞机型号 🛩  ✈️ F22");
        return null;
    }

    @Override
    public String start() {
        System.out.println("F22 start");
        return null;
    }

    @Override
    public String run() {
        System.out.println("F22 run");
        return null;
    }

    @Override
    public String takeOff() {
        System.out.println("F22 take-off");
        return null;
    }

    @Override
    public String fly() {
        System.out.println("F22 fly");
        return null;
    }

    @Override
    public void usePlan() {
        super.usePlan();
    }
}
