package com.liang.designPattern._02action.observer.eg1.observersAndSubject;

import com.liang.designPattern._02action.observer.eg1.observersAndSubject.Subject;

public abstract class AbstractObserver {
    //声明被观察者对象
    protected Subject subject;
    //刷新方法
    public abstract void update();
}