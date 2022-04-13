package com.liang.designPattern._01creator.factoryMethod;

public class TestFactory {
    //
    TopFactory product1Factory = new Product1Factory();
    TopFactory product2Factory = new Product2Factory();

    Product1 product1 = (Product1) product1Factory.createProduct();
}
