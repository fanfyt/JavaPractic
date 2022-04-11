package com.liang.designPattern._03constructor.facadePattern.eg1;

import com.liang.designPattern._03constructor.facadePattern.eg1.make.MakeCocoColar;
import com.liang.designPattern._03constructor.facadePattern.eg1.make.MakeCocoColarImpl;
import com.liang.designPattern._03constructor.facadePattern.eg1.make.MakeHemberger;
import com.liang.designPattern._03constructor.facadePattern.eg1.make.MakeHembergerIml;

public class FrontService {
    MakeCocoColar makeCocoColar;
    MakeHemberger makeHemberger;

    void OrderCocoColar(){
        makeCocoColar = new MakeCocoColarImpl();
        makeCocoColar.takeCup();
        makeCocoColar.takeCocoColar();
        makeCocoColar.pourInCup();
        System.out.println("===========可口可乐做好了============");
    }
    void OrderHemberger(){
        makeHemberger = new MakeHembergerIml();
        makeHemberger.makeBread();
        makeHemberger.makeVegtable();
        makeHemberger.makeBeef();
        System.out.println("==============汉堡🍔做好了=================");
    }
    void OrderCombo1(){
        System.out.println("          套餐一开始制作：                ");
        OrderHemberger();
        OrderCocoColar();
        System.out.println("=========套餐一的汉堡🍔和可乐已制作完成==========");
    }

}
