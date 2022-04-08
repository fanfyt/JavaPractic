package com.liang.designPattern._01creator.singleTon;

//懒加载-懒汉模式
public class LanHanShi {

    //先声明
    private static LanHanShi lanhan;
    //构造方法
    public LanHanShi() {
    }
    //使用synchronized锁
    public synchronized LanHanShi getlanhan(){
        if (lanhan == null){
            lanhan = new LanHanShi();
        }
        return lanhan;
    }

    public static void main(String[] args) {
        LanHanShi lanhan1 = LanHanShi.lanhan;
        LanHanShi lanhan2 = LanHanShi.lanhan;

        System.out.println(lanhan1==lanhan2);
    }
}
