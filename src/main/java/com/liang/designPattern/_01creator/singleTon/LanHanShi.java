package com.liang.designPattern._01creator.singleTon;

public class LanHanShi {

    private static LanHanShi lanhan;

    public LanHanShi() {
    }
    public synchronized LanHanShi getlanhan(){
        if (lanhan == null){
            lanhan = new LanHanShi();
        }
        return lanhan;
    }

    public static void main(String[] args) {
        LanHanShi lanhan1 = LanHanShi.lanhan;
    }
}
