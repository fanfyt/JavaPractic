package com.liang.designPattern._02action.observer.eg1.observersAndSubject;

import java.util.ArrayList;
import java.util.List;
public class Subject {
    //用于存放观察者的list
    private List<AbstractObserver> observers =  new ArrayList<>();
    //属性状态
    private int state;
    //获取状态方法
    public int getState(){
        return state;
    }
    //修改属性状态方法
    public void setSelected(int state){
        this.state = state;
        notifyObservers(); //当改变state时候，通知所有观察者
    }
    //通知广播方法，通知每个观察者，调用它们的update方法进行通知
    public void notifyObservers(){
        for(AbstractObserver observer : observers){
            observer.update();
        }
    }

    //在subject里添加观察者
    //在new一个Observer对象的时候，会把实现的对象放入到subject对象的list中保存
    public void attach(AbstractObserver abstractObserver) {
        observers.add(abstractObserver);
    }
}
