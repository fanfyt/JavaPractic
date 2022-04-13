package com.liang.designPattern._02action.observer.eg1;

import javax.security.auth.Subject;
import java.util.Observable;
import java.util.Observer;

public class Observer1 implements MyAbstractObserver {

    private final SubjectInter subject;

    public Observer1(SubjectInter subject) {
        this.subject = subject;

    }

    @Override
    public Subject subject() {
        return null;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Observer1 is updating ");
    }
}
