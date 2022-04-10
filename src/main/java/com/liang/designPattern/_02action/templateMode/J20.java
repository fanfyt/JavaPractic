package com.liang.designPattern._02action.templateMode;

public class J20 extends Plane{
    @Override
    public String getName() {
        System.out.println("飞机型号 🛩 ✈ J20");
        return null;
    }

    @Override
    public String start() {
        System.out.println("J20启动");
        return null;
    }

    @Override
    public String run() {
        System.out.println("J20滑跑");
        return null;
    }

    @Override
    public String takeOff() {
        System.out.println("J20起飞");
        return null;
    }

    @Override
    public String fly() {
        System.out.println("J20飞行");
        return null;
    }

    @Override
    public void usePlan() {
        super.usePlan();
    }
}
