package com.liang.leecode._007整数反转;

public class Reverse {

    public static void main(String[] args) {
        System.out.println(1534236469 > Integer.MAX_VALUE);
        Reverse reverse = new Reverse();
        int reverse1 = reverse.reverse(-2147483648);
        System.out.println(reverse1);
    }

    // 报错用例： x= 1534236469,已解决；
    public int reverse(int x) {
        long l = x > 0 ? x : Math.abs((long) x);
        long main = 0L;
        long s = 1;
        while (s > 0) {
            s = l / 10;
            long i = l % 10;
            main = main * 10 + i;
            l = s;
        }
        main = x > 0 ? main : -main;
        if (main < Integer.MIN_VALUE || main > Integer.MAX_VALUE) {
            return 0;
        }
        return Math.toIntExact(main);
    }

    /**
    作者：力扣官方题解
    链接：https://leetcode.cn/problems/reverse-integer/solutions/755611/zheng-shu-fan-zhuan-by-leetcode-solution-bccn/
    来源：力扣（LeetCode）
    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    * */
    public int reverseLeetCode(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }

}
