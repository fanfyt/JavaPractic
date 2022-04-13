package com.liang.designPattern._02action.observer.eg1;

import javax.security.auth.Subject;
import java.util.Observable;
import java.util.Observer;

public interface MyAbstractObserver extends Observer {

    Subject subject();

    @Override
    public void update(Observable o, Object arg);
}
