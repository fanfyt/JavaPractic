package com.calculate.inner.basic;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

public class _01removeRepeateAndSort {

    public static LinkedList removeAndSort(LinkedList<Integer> link){
        int mid ;
        for(int i = 0;i < link.size();i++){
            int a = link.get(i);
            for (int j = 1;j<link.size()-1;j++){
                int b = link.get(j);
                if (a==b){
                    link.remove(j);
                };
                if (a > b){
                    mid = a;
                    link.set(i, b);
                    link.set(j, mid);
                    System.out.print("proceeding......"+"a"+a+"   b"+b);
                    System.out.println("   linking"+link);
                }
            }
        }
        System.out.println(link.toString());
        return link;
    }






    public static void main(String[] args) {
        LinkedList<Integer> link = new LinkedList<>();
//        link.set(0,5);
       link.add(5);
       link.add(4);
       link.add(3);
       link.add(2);
       link.add(1);
        System.out.println(link);
        removeAndSort(link);
    }
}
