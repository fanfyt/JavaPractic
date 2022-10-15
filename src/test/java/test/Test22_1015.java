package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test22_1015 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(6);
        list.add(7);


        int[] a = {2, 3, -1, 4, 7, 6, 5};
        System.out.println(Arrays.toString(a));

        Arrays.sort(a);
        System.out.println("a = " + Arrays.toString(a));


    }
}
