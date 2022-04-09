package com.liang.designPattern._03constructor.adepterMode.objectAdepter.eg2;

public class ForeignCenter {
    private String name;
    public String nname;

    public ForeignCenter(String name) {
        this.name = name;
    }

    public ForeignCenter() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }


    public void jingong(){
        System.out.println("外籍中锋进攻");
    }
    public void fangshou(){
        System.out.println("外籍中锋防守");
    }
}
