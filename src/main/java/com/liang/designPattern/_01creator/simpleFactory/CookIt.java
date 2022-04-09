package com.liang.designPattern._01creator.simpleFactory;
//工厂类，更具参数返回实例
public class CookIt {
    Food food;
    Food getFood(String foodName){
        if("馒头"==foodName){
            food = new ManTou();
            System.out.println("馒头做好了");
        }else if ("面包"==foodName){
            food = new Bread();
            System.out.println("面包做好了");
        }else {
            System.out.println("抱歉，余额不足");
            food = null;
        }
        return food;
    }
}
