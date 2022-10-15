package com.liang.leecode._4寻找两个正序数组的中位数;

import java.util.Arrays;

public class S_22_10_15 {
    public static void main(String[] args) {

        int[] a1 = {0, 0, 0, 0, 0}, b1 = {1, 3};
        int[] a2 = {-1, 0, 0, 0, 0, 0, 1}, b2 = {2};

//        double v = findMedianSortedArrays(a1, a2);
        double v = findMedianSortedArrays(b1, b2);
        System.out.println(v);
    }

    /**
     * 组合后求中位数
     *
     * @param nums1 第一个数组
     * @param nums2 第二个数组
     * @return double d
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int l3 = l1 + l2;
        int[] nums3 = new int[l3];
        double result;
        System.arraycopy(nums1, 0, nums3, 0, l1);
        System.arraycopy(nums2, 0, nums3, l1, l2);

        System.out.println(Arrays.toString(nums3));
        Arrays.sort(nums3);
        System.out.println(Arrays.toString(nums3));
        int mid;

        // 奇数情况
        if ((l3 & 1) == 1) {
            mid = l3 >> 1;
            result = nums3[mid];
        } else {
            mid = (l3 - 1) >> 1;
            result = (double) (nums3[mid] + nums3[mid + 1]) / 2;
        }
        return result;
    }


}
