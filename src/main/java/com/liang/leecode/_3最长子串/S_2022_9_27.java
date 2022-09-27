package com.liang.leecode._3最长子串;


/**
 * 1.一个对象，对象用来定义目前最长的字串信息：起止位置
 * <br/>
 * 2. 拿到第一个字母，开始记录：
 * 1.字母位置
 * 2.字母值
 * <br/>
 * 3. 往后每到下一个字母，先判断是否和之前的字母相同，
 * <br/>  若相同：则用此字母位置减去首字母位置，得到差 + 1 为目前子串长度，若大于目前子串长
 * 则替换。 否则继续
 * <br/> 若不同：则将目前的字符记录，直至遇到与首字母相同的字符。
 * <br/>
 * 4. 当拿到一个子串后，就从下一个字母往后判断： 拿到子串+1 的字符串，然后和往后的字符进行对比，若不同就停止，回到下下个字母依次规律进行判断，直至有相同子串大于目前的长度，才进行替换。
 */
public class S_2022_9_27 {

    public static void main(String[] args) {
        System.out.println(
                Solution.lengthOfLongestSubstring("abcabcde")
        );
    }

    static class Solution {
        public static int lengthOfLongestSubstring(String s) {

            int a = 0;
            int b = 0;
            int length = 0;
            boolean add;
            int i = 0;
            int j = 0;
            // 1、 依次往后走: i是首字母位置
            for (; i < s.length(); i++) {

                // 2、 对字符串进行比较，把目前最长的拿到手里： j是被比较首字母位置
                for (j = i; j < s.length() - 1; j++) {
                    if (length == 0) {
                        System.out.println("加上：" + s.charAt(j));
                        b = 1;
                        length = 1;
                    } else {

                        add = true;
                        // 3、 对拿到的子串进行遍历，判断是否和下一个重复
                        for (int k = 0; k < s.substring(a, b).length(); k++) {

                            // 如果重复，就停止判断，
                            if (s.substring(a, b).charAt(k) == s.charAt(j)) {
                                System.out.println(" ---" + s.substring(a, b).charAt(k) + "和" + s.charAt(j) + "比较 ---");

                                System.out.println(" for 3 ====:" + s.substring(a, b));
                                add = false;
                                break;
                            }
                        }
                        // 如果没有置为 false ，说明没有相同的字符，则把此位置的字符加上，长度加1
                        if (add) {
                            System.out.println(" 加上：" + s.charAt(j));
                            b = b + 1;
                            length++;
                            System.out.println("if(add): " + s.substring(a, b));
                        }
                        // 如果置为了 false,说明此位置不可连续，更换求子串位置，目前数据暂存
                        else {

                            break;
                        }

                    }
                }
            }

            System.out.println(s.substring(a, b));
            return length;
        }
    }

}
