package com.liang.leecode._3最长子串;


// "abcabcbb"  3
public class S_2022_9_28 {
    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLongestSubstring("dvdf"));
    }

    static class Solution {

        public static int lengthOfLongestSubstring(String s) {


            int result = 0;

            if (s.length() == 0) {
                return 0;
            } else {
                int a = 0;
                int b = 1;
                int length = 1;
                while (b < s.length()) {  // abcabcbb
                    length = s.substring(a, b).length();
                    if (s.substring(a, b).contains(s.substring(b, b + 1))) {
                        b = a + 2;
                        a = a + 1;
//                        a = b;
//                        b = b + 1;

                     /*   if(s1.equals(s2)){
                            length = 1;
                        }else {
                            length = 0;
                        }*/
                    } else {
                        System.out.println(" add:  " + s.charAt(b));

                        length++;
                        if (length > result) {
                            result = length;
                        }
                        b = b + 1;
                    }

                    System.out.println(a + " + " + b + "  = " + s.substring(a, b));
                }


            }


            return result;
        }


    }
}
