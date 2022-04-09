package com.liang.designPattern._03constructor.adepterMode.objectAdepter.eg1;

//适配器类
public class Adapter extends Target {
    //建立一个需要扩展的对象
    private Adaptee adeptee = new Adaptee();

    //重写原有对象的方法，在里头调用需要扩展的方法
    @Override
    public void Rqueset(){
        adeptee.specialResult();
    }

    public static void main(String[] args) {
        Target target = new Adapter();
        target.Rqueset();
    }
}
