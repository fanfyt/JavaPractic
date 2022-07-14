package com.liang.leecode._3最长子串;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

/**
 * @author FL
 */
public class LongestSubString {

    String s = "abcabcbb";

    public int lengthOfLongestSubstring(String s) {

        StringBuilder input = new StringBuilder(s);
        // 目前持有的子串
        StringBuilder sub;
        // 目前子串的长度
        int length = 0;
        // 被截取的子串,默认为字符串第一个字符
        if (StringUtils.isNotBlank(input.toString())) {
            StringBuilder pick = new StringBuilder(input.substring(0, 1));

            // 逐个遍历,拿到一个就放到手中，
            // 拿到下一个就遍历手中的，进行比较，如果不同就append，相同就跳过这个
            for (int i = 0; i < input.length(); i++) {


            }
        }


        return 1;
    }

    @Test
    public void test() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append("2");
        stringBuilder.append("3");
        stringBuilder.append("4");
        System.out.println(stringBuilder.substring(0, 1));
    }
}
