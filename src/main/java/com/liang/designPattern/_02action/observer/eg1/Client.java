package com.liang.designPattern._02action.observer.eg1;

import java.util.Observer;

public class Client {
    public static void main(String[] args) {
        RealSubject subject = new RealSubject();
        Observer observer1 = new Observer1();
        subject.addObserver(observer1);
    }
}
