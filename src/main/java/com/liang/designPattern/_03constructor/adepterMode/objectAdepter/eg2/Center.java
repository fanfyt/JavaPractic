package com.liang.designPattern._03constructor.adepterMode.objectAdepter.eg2;

public class Center extends Player{
    public Center(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println( name +"中锋进攻");

    }

    @Override
    public void defense() {
        System.out.println( name +"中锋进攻");

    }
}
