package com.liang.designPattern._03constructor.facadePattern.eg1;

public class ClientOrderTaoCan {
    public static void main(String[] args) {
        FrontService frontService = new FrontService();

        //下订单订购可乐
        frontService.OrderCocoColar();
        //下订单订购汉堡 🍔
        frontService.OrderHemberger();

        System.out.println("                                             ");
        System.out.println("                                             ");
        System.out.println("                                             ");
        //下订单订购套餐一
        frontService.OrderCombo1();




    }
}
