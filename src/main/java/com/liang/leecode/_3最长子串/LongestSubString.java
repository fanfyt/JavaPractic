package com.liang.leecode._3最长子串;

/**
 * @author FL
 */
public class LongestSubString {

    String s = "abcabcbb";

    public int lengthOfLongestSubstring(String s) {
        StringBuilder sub;
        String pick;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length() - i; j++) {
                pick = s.substring(i,j);
                if(true){

                }
            }
        }
        return 1;
    }
}
