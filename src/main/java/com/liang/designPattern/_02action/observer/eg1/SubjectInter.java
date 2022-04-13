package com.liang.designPattern._02action.observer.eg1;

import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

public class SubjectInter  {

    //被观察者里头有一个观察者列表
    private List<Observer> observers = new Vector<>();

    //被观察目标标志
    private Integer state;

    //get状态方法
    public Integer getState() {
        return state;
    }

    //set状态方法
    public void setState(Integer state) {
        this.state = state;
    }

    //绑定观察者，注册观察者到列表里
    public void addObserver(Observer observer) {
        boolean add = observers.add(observer);
        String r = true?"新增成功√":"新增失败×";
    }
    //删除观察者
    public String deleteObserver(Observer observer){
        Boolean a =  observers.remove(observer);
        String r = true?"删除成功":"删除失败";
        return r;
    }

    public  void notifyObservers(Integer state){
        for(Observer observer : observers){
            observer.update((Observable) observer,state);
        }
    }

}
