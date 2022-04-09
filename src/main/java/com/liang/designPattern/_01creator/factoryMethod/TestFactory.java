package com.liang.designPattern._01creator.factoryMethod;

public class TestFactory {
    Product1Factory product1Factory = new Product1Factory();

    Product1 product1 = (Product1) product1Factory.createProduct();
}
