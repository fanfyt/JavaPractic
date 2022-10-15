package com.liang.leecode._4寻找两个正序数组的中位数;


import java.util.Arrays;

/**
 * 1、分离
 * l1, l2
 * l2, l1         <br/>
 * 2、相交
 * l1 × l2
 * l2 × l1         <br/>
 * 3、包含
 * l1
 * l2
 */
//@Slf4j
public class S_2022_09_28 {

    public static void main(String[] args) {

        int[] a = {0, 0};
        int[] b = {0, 0};
        double medianSortedArrays = Solution.findMedianSortedArrays(a, b);
        System.out.println(medianSortedArrays);
    }

    static class Solution {
        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int l1 = nums1.length;
            int l2 = nums2.length;
            int size = l1 + l2;
            // 判断总长度是否为奇数
            boolean jishu = size % 2 != 0;

            boolean f1 = true;
            boolean f2 = true;
            for (int i : nums1) {
                if (i != 0) {
                    f1 = false;
                    break;
                }
            }
            for (int i : nums2) {
                if (i != 0) {
                    f2 = false;
                    break;
                }
            }
            if (f1 && f2) {
                return 0;
            }

            //1. 两个数组都只有一个元素
            if (l1 == 1 && l2 == 1) {
                return (double) (nums1[0] + nums2[0]) / 2;
            } else if (l1 > 1 && l2 > 1) {

                double a1 = nums1[0];
                double a2 = nums1[nums1.length - 1];

                double b1 = nums2[0];
                double b2 = nums2[nums2.length - 1];

                int target = ((size) / 2 + 1); // 奇数时候的中间数位置
                double targetA = (size / 2);// 偶数时候的第一个中间数位置;
                double targetB = (targetA + 1);// 偶数时候的第二个中间数位置;

                // 判断数组关系
                int type = judgeType(a1, a2, b1, b2);

                // 是奇数的话，取中间数
                if (jishu) {
                    switch (type) {
                        case 1: {
                            return caseA1(a2, target, nums1, nums2);
                        }
                        case 2: {
                            return caseA1(b2, target, nums1, nums2);
                        }
                        case 3: {
                            return caseB1(b1, a2, target, nums1, nums2, (int) size);
                        }
                        case 4: {
                            return caseB1(a1, b2, target, nums1, nums2, (int) size);
                        }
                        default:
                            return -1;
                    }
                }

                // 偶数的话，取中间两个数
                else {

                    switch (type) {
                        case 1: {
                            return caseA2(a2, target, nums1, nums2);
                        }
                        case 2: {
                            return caseA2(b2, target, nums1, nums2);
                        }
                        case 3: {
                            return caseB2(b1, a2, targetA, targetB, nums1, nums2, (int) size);
                        }
                        case 4: {
                            return caseB2(a1, b2, targetA, targetB, nums1, nums2, (int) size);
                        }
                        default:
                            return -1;

                    }
                }
            } else {
                int i = 0;
                int[] list = new int[l1 + l2];
                for (; i < nums1.length; i++) {
                    list[i] = nums1[i];
                }
                for (int j = 0; j < nums2.length; j++) {
                    list[i + j] = nums2[j];
                }

                Arrays.sort(list);
                if (jishu) {
                    return list[(int) (size / 2)];
                } else {
                    int pos = (int) (size / 2);
                    return (double) (list[pos] + list[pos + 1]) / 2;
                }
            }

        }

        /**
         * 奇数， 分离的情况
         *
         * @param tail   第一个数组末端的关键数字
         * @param target 中位数的位置
         * @param nums1  第一个数组
         * @param nums2  第二个数组
         * @return double 结果
         */
        private static double caseA1(double tail, int target, int[] nums1, int[] nums2) {
            if (target > tail) {
                return nums2[target - nums1.length - 1];
            } else {
                return nums1[target - nums2.length - 1];
            }
        }

        /**
         * 分离：偶数的情况
         *
         * @param targetA 目标位置1
         * @param targetB 目标位置2
         * @param nums1   asd
         * @param nums2   d
         */
        private static double caseA2(double targetA, double targetB, int[] nums1, int[] nums2) {
            if (targetA > nums1.length) {
                return (double) (nums2[0] + nums2[1]) / 2;
            } else if (targetB <= nums1.length) {
                return (double) (nums1[0] + nums1[1]) / 2;
            } else if (targetA == nums1.length) {
                return (double) (nums1[0] + nums2[nums2.length - 1]) / 2;
            } else {
                return -2;
            }
        }


        /**
         * 相交：奇数的情况
         */
        private static double caseB1(double b1, double a2, double target, int[] nums1, int[] nums2, int size) {

            int i = 0;
            int j = 0;

            for (; i < nums1.length; i++) {
                if (i == target) {
                    break;
                } else if (i == nums1.length - 1) {
                    for (; j < nums2.length; j++) {
                        if ((nums1.length + j) == target) {
                            break;
                        }
                    }
                }
            }
            if (j > 0) {
                return nums1[(int) target];
            } else {
                return nums2[j];
            }
        }

        /**
         * 相交：偶数的情况
         *
         * @param nums1   第一个数组
         * @param nums2   第二个数组
         * @param second  第二个关键数：第一个数组的最后一个数字
         * @param third   第三个关键数：第二个数组的第一个数字
         * @param size    两个数组大小之和
         * @param targetA 偶数求求中位数的第一个数字位置下标
         * @param targetB 偶数求求中位数的第二个数字位置下标
         * @return double 中位数
         */
        private static double caseB2(double second, double third, double targetA, double targetB, int[] nums1, int[] nums2, int size) {

            double c1 = 0;
            double c2 = 0;
            if (targetB < second) {
                c1 = nums1[(int) targetA];
                c2 = nums1[(int) targetB];
            } else if (targetA >= third) {
                c1 = nums2[(int) targetA];
                c2 = nums2[(int) targetB];
            }

            // 中位数位于中间部分的情况
            if (targetB >= second && targetB <= third) {
                int i = 0;
                int j = 0;
                for (; i < nums1.length; i++) {
                    // 找到nums1 < nums2 首位数字的长度
                    if (nums1[i] > second) {
                        break;
                    }
                }
                for (; j < nums2.length; j++) {
                    // 找到nums2 > nums1 末尾数组的长度
                    if (nums2[j] > third) {
                        break;
                    }
                }

                /*
                 * 1.先判断 第一部分长度，再判断重合部分中第一个数组的长度，在判断重合部分中第二个数组的长度；
                 * 2.然后从第一个数组和第二个数组分别拿出对应部分的数组成员进行排序
                 * 3.从排序好的第三个数组中找到指定位置，取出对应两个数字
                 * */
                int midAL = nums1.length - i;
                int midBL = j;

                int[] mid = new int[midAL + midBL];
                for (int m = 0; m < mid.length; m++) {
                    for (int k1 = i; k1 < nums1.length; k1++) {
                        mid[m] = nums1[k1];
                        m++;
                    }
                    for (int k2 = 0; k2 < j; k2++) {
                        mid[m] = nums2[k2];
                        m++;
                    }
                }

                c1 = mid[(int) targetA];
                c2 = mid[(int) targetB];

            } else if (targetA >= second && targetA <= third) {

            }

            return (c1 + c2) / 2;
        }


        /**
         * 判断数组关系
         *
         * @param a1 第一个数组的首位数
         * @param a2 第一个数组的末位数
         * @param b1 第二个数组的首位数
         * @param b2 第二个数组的末位数
         * @return int 位置关系类型
         */
        private static int judgeType(double a1, double a2, double b1, double b2) {

            int result = 0;

            // 1. 分离:  a1 a2 b1 b2 或者  b1 b2 a1 a2
            {
                // l1 + l2
                if (a1 <= a2 && a2 <= b1 && b1 <= b2) {
                    result = 1;
                }
                // l2 + l1
                else if (b1 <= b2 && b2 <= a1 && b1 <= a2) {
                    result = 2;
                }
            }

            // 2.相交:  a1 b1 a2 b2 或者  b1 a1 b2 a2
            {
                // l1 * l2
                if (a1 <= b1 && b1 <= a2 && b1 <= b2) {
                    result = 3;
                }
                // l2 * l1
                else if (b1 <= a1 && a1 <= b2 && b2 < a2) {
                    result = 4;
                }
            }

            // 3. 包含： a1 b1 b2 a2 或者 b1 a1 b2 a2
            {
                // l1(l2)
                if (a1 <= b1 && b2 <= a2) {
                    result = 3;
                }
                //l2(l1)
                else if (b1 <= a1 && a2 <= b2) {
                    result = 3;
                }
            }
            return result;
        }
    }
}
