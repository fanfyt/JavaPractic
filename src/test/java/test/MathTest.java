package test;

import org.junit.jupiter.api.Test;

public class MathTest {
    public static void main(String[] args) {

        double b = 2;
        double a = 3;
        double c = 5;

        System.out.println(a/b);
        System.out.println(c/2);
        System.out.println(Math.floor(a/b));
        System.out.println(Math.ceil(a/b));

        System.out.println(Math.floor(c/b));
        System.out.println(Math.ceil(c/b));
    }


    @Test
    public void test1(){
        int a = 6;
        int b = 2;
        System.out.println(a/b);
    }
}
