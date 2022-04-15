package com.liang.designPattern._02action.observer.eg1.observersAndSubject.observers;

import com.liang.designPattern._02action.observer.eg1.observersAndSubject.AbstractObserver;
import com.liang.designPattern._02action.observer.eg1.observersAndSubject.Subject;

public class Observer_2 extends AbstractObserver {
    public Observer_2(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Observer_2 观察到了变化"+subject.getState());
    }
}
