package com.calculate.inner.basic;
import java.util.Arrays;
import java.util.Iterator;
public class BubleSort {

    public static void main(String[] args) {
        int[] array ={3,2,4,3,8,1};
        int[] array2 ={3,2,4,3,8,1};

        for (int i = 0; i < array.length; i++) {
            int mid =0;
            for (int j = 0;j < array.length-i;j++){
                if (array[j+i]<array[i]){
                    mid = array[j+i];
                    array[j+i] = array[i];
                    array[i] = mid;
                }
            }
        }
        Iterator<Integer> iterator = Arrays.stream(array).iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        Arrays.stream(array2).sorted().forEach(System.out::println);

    }
}
