package com.liang.designPattern._01creator.builderMode.eg1;

//builder实现类
public class SuitBuilder implements BuildInterface{

    private SuitPo suit = new SuitPo();

    public SuitBuilder() {
    }

    public SuitPo getSuit() {
        return suit;
    }

    public void setSuit(SuitPo suit) {
        this.suit = suit;
    }

    @Override
    public void createCoat() {
        suit.setCoat("normal Coat");
        System.out.println("createCoat");
    }

    @Override
    public void createGoodCoat() {
        suit.setCoat("Good Coat");
        System.out.println("createGoodCoat");
    }

    @Override
    public void createShoes() {
        suit.setShoes("Shoes");
        System.out.println("createShoes");
    }

    @Override
    public void createGoodShoes() {
        suit.setShoes("Good Shoes");
        System.out.println("createGoodShoes");
    }

    @Override
    public void createPlant() {
        suit.setPlant(" plant");
        System.out.println("createPlant");
    }

    @Override
    public void createGoodPlant() {
        suit.setPlant("Good Plant");
        System.out.println("creating---GoodPlant");
    }


    public SuitPo returnSuit(){
        return suit;
    }


}
