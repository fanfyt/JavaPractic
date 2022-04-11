package com.liang.designPattern._03constructor.facadePattern.eg1.make;

public class MakeHembergerIml implements MakeHemberger{
    @Override
    public void makeBread() {
        System.out.println("making Bread");
    }

    @Override
    public void makeBeef() {
        System.out.println("making Beef");
    }

    @Override
    public void makeVegtable() {

        System.out.println("making Vegetables");
    }
}
