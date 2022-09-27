package com.liang.动态代理.jdk动态代理;

public class Test {
    public static void main(String[] args) {
        Calculator proxy = CalculatorProxy.getProxy(new MyCalculator());
        proxy.add(1, 1);
        System.out.println(proxy.add(1, 1));
        System.out.println(proxy.getClass());
    }
}
