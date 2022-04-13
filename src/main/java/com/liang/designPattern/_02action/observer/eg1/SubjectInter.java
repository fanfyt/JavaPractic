package com.liang.designPattern._02action.observer.eg1;

import java.util.List;
import java.util.Observer;

public class SubjectInter {

    //被观察者里头有一个观察者列表
    private List<Observer> observers;

    //被观察目标标志
    private int state;

    //get状态方法
    public Integer getState() {
        return state;
    }

    //set状态方法
    public void setState(Integer state) {
        this.state = state;
    }

    //绑定观察者，注册观察者到列表里
    public void attach(Observer observer) {
        observers.add(observer);
    }


}
