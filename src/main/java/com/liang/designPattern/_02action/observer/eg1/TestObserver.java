package com.liang.designPattern._02action.observer.eg1;

import com.liang.designPattern._02action.observer.eg1.observersAndSubject.observers.Observer_1;
import com.liang.designPattern._02action.observer.eg1.observersAndSubject.observers.Observer_2;
import com.liang.designPattern._02action.observer.eg1.observersAndSubject.observers.Observer_3;
import com.liang.designPattern._02action.observer.eg1.observersAndSubject.Subject;

public class TestObserver {
    public static void main(String[] args) {
        Subject subject = new Subject();
        //在new一个观察者的时候，传入一个subject对象
        Observer_1 observer_1 = new Observer_1(subject);
        new Observer_2(subject);
        new Observer_3(subject);

        System.out.println("现在设置state为5");
        subject.setSelected(5);

        observer_1.update();

    }
}
