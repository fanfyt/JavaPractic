package com.calculate.basic;

import javax.print.StreamPrintService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class BubleSort {


    public static void main(String[] args) {
        int m = 0;
        int j =0;
        int i = 0;
        Integer[]a = {3,2,1};
        for(i=0;i<a.length;i++){
            for (j = i+1;j<a.length-1-i;j++){
                if (a[i] > a[j]){
                    m = a[j];
                    a[j] = a[i];
                    a[i] = m;
                    System.out.println(j);
                }
            }
        }
        Arrays.asList(a).stream().forEach(System.out::print);
    }
}
