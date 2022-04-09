package com.liang.designPattern._03constructor.proxyMode.staticProxy;

public class SuperMan extends Man{
    Man man;

    public SuperMan(Man man) {
        this.man = man;
    }

    @Override
    void run(){
        System.out.println("换衣服，把裤衩穿在外头");
        man.run();
        System.out.println("换衣服，把裤衩穿在里头");
    }

    public static void main(String[] args) {
        Man man = new Man();
        SuperMan san = new SuperMan(man);
        san.run();
    }
}
