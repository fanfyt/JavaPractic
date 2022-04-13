package com.liang.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C3B2A1 {

    public static void main(String[] args) {
        String a="1b2c3a4d5e";
        System.out.println(a.charAt(1));
        System.out.println();
       List list = new ArrayList();
        for (int i = 0; i < a.length(); i++) {
            if ((i%2)==0||i==0){
                for (int j = 0;j<i;j++){
                    list.add(a.charAt(i+1));
                }
            }
        }
        System.out.println(list);
    }
}
