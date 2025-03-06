package com.wjw;

import java.util.Arrays;

/*
合并两个有序数组
两个非递减的数组， nums1的长度为m+n ，有效的数字为m个，nums2的长度为n，最后合并到nums1中
循环，当i,j>=0的时候，判断大的一方添加到k的位置，位置迭代
如果i还剩下 不需要修改了
如果j还剩下 直接添加到num1的位置上
 */
public class Lc88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 0, 0, 0, 0};
        int[] nums2 = {3, 5, 7, 8};
        Lc88 test = new Lc88();
        test.merge(nums1, 2, nums2, 4);
        System.out.println(Arrays.toString(nums1));
    }
}
