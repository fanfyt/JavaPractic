package com.liang.designPattern._03constructor.adepterMode.objectAdepter.eg2;

public class Guards extends Player {
    public Guards(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println( name +"后卫进攻");

    }

    @Override
    public void defense() {
        System.out.println( name +"后卫进攻");

    }
}
