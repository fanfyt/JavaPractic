package com.liang.designPattern._02action.templateMode;

public class PlayPlane {
    public static void main(String[] args) {
        Plane F22 = new F22();
        Plane J20 = new J20();
        F22.usePlan();
        J20.usePlan();
    }
}
