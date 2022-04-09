package com.liang.designPattern._01creator.simpleFactory;

public class TestFoodFactory {
    public static void main(String[] args) {
        //new一个工厂对象
        CookIt cookIt = new CookIt();
        //使用工厂对象传入参数调用不同方法
        cookIt.getFood("馒头");
        cookIt.getFood("面包");
        cookIt.getFood("满汉全席");
    }
}
