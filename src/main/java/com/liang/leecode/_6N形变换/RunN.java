package com.liang.leecode._6N形变换;

import org.junit.jupiter.api.Test;


public class RunN {


    @Test
    void runIt() {
        String input = "ABC"; /*
        ACE
        BD
        */
        String convert = convert(input, 2);
        System.out.println();
        System.out.println("输入字符串");
        System.out.println(input);
        System.out.println();
        System.out.println("输出答案");
        System.out.println(convert);
//        System.out.println("正确答案 \nPAHNAPLSIIGYIR");

    }

    public String convert(String s, int numRows) {
        int length = s.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        if (length == 1 || numRows == 1) {
            return s;
        }

        int count = 0;
        boolean flag = true;
        // ABCDEFG
        Character[][] arr = new Character[numRows][length / 2 + 1];
        if (numRows == 2) {
            for (int i = 0; i < length; ) {
                for (int i1 = 0; i1 < 2 && i < length; i1++) {
                    arr[i1][count] = s.charAt(i);
                    i++;
                }
                count++;
            }
            for (Character[] characters : arr) {
                for (Character character : characters) {
                    if (character != null) {
                        stringBuilder.append(character);
                    }
                }
            }
            return String.valueOf(stringBuilder);
        }

        for (int i = 0; i < length; ) {
            // 直接保存
            if (flag) {
                for (int j = 0; j < numRows - 1 && i < length; j++) {
                    char c = s.charAt(i);
                    arr[j][count] = c;
                    i++;
                }
                flag = false;
            }
            // 错位保存
            else {
                if (numRows > 2) {
                    for (int k = numRows - 1; k > 0 && i < length; k--) {
                        char c = s.charAt(i);
                        arr[k][count] = c;
                        i++;
                    }
                } else {
                    for (int o = 1; o < numRows; o++) {
                        char c = s.charAt(i);
                        arr[o][count] = c;
                        i++;
                    }
                }
                flag = true;
            }
            count++;
        }

        for (int l = 0; l < numRows; l++) {
            for (int m = 0; m < arr[l].length; m++) {
                Character character = arr[l][m];
                if (character != null)
                    stringBuilder.append(character);
            }
        }

        return String.valueOf(stringBuilder);
    }

}
