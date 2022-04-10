package com.liang.designPattern._02action.templateMode;

public abstract class Plane {

    public Plane() {
    }

    abstract public String getName();
    abstract public String start();
    abstract public String run();
    abstract public String takeOff();
    abstract public String fly();
    public void usePlan(){
        getName();
        start();
        run();
        takeOff();
        fly();
    }

}
