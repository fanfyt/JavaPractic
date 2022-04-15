package com.liang.designPattern._02action.observer.eg1.observersAndSubject;

import com.liang.designPattern._02action.observer.eg1.observersAndSubject.Subject;

public abstract class AbstractObserver {
    protected Subject subject;
    public abstract void update();
}
