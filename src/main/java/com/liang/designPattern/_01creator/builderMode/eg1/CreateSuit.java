package com.liang.designPattern._01creator.builderMode.eg1;

public class CreateSuit {

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
