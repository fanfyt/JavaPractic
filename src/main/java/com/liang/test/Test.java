package com.liang.test;


public class Test {
    public static void main(String[] args) {

        int a = 1000000;

        for (int i = 1; i < a; i++) {
            int j = 100;
            while (j > 0 && i < a) {
                System.out.print((char) i);
                j--;
                i++;
            }
            System.out.println();
        }
    }
}
