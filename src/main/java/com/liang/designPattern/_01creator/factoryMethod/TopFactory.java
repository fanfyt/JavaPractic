package com.liang.designPattern._01creator.factoryMethod;

//顶级工厂类，只定具体工厂应实现的方法
public interface TopFactory {
    Product createProduct();
}
