package com.liang.designPattern._03constructor.adepterMode.objectAdepter.eg1;

//客户所期待的接口。目标可以是具体的类h或者抽象类，也可以是接口
public class Target {
    public void Rqueset(){
        System.out.println("普通请求");
    }
}
