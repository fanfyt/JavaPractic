package com.liang.designPattern._02action.observer.eg1;

import javax.security.auth.Subject;

public class RealSubject extends SubjectInter {
    //被观察对象的属性
    private int state;
    @Override
    public Integer getState(){
        return state;
    }
    public void setState(int state){
        this.state=state;
//主题对象(目标对象)值发生改变
        this.notifyObservers(state);
    }

}
