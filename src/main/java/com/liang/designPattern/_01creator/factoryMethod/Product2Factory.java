package com.liang.designPattern._01creator.factoryMethod;

//具体实现的工厂类2，对顶级工厂类指定的方法进行实现.new出产品对象并返回
public class Product2Factory implements TopFactory{
    @Override
    public Product createProduct() {
        return new Product2();
    }
}
