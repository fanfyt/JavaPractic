package com.liang.designPattern._01creator.builderMode.eg1;

//组装创建
public class CreateSuit {

    //在组装创建的类中new一个biulder对象，然后自定义不同的建造逻辑，通过Buidler的方法返回创建好的对象
    SuitBuilder suitBuilder = new SuitBuilder();

    public SuitPo createNormalsuite(){
        suitBuilder.createCoat();
        suitBuilder.createPlant();
        suitBuilder.createShoes();
        return suitBuilder.returnSuit();
    }
    public SuitPo createGoodsuite(){
        suitBuilder.createGoodPlant();
        suitBuilder.createGoodCoat();
        suitBuilder.createGoodShoes();
        return suitBuilder.returnSuit();
    }


    public static void main(String[] args) {

        CreateSuit suitCreater = new CreateSuit();

        SuitPo goodSuit = suitCreater.createGoodsuite();
        System.out.println("suit:"+goodSuit);
        SuitPo normalSuit = suitCreater.createNormalsuite();
        System.out.println("suit:"+normalSuit);
    }
}
