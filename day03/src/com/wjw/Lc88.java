package com.wjw;

// leetcode 88
public class Lc88 {
    /*
    下面两种方法思维的差异
    第一种，是每次遍历都修改值

    // 条件的想法
    1. 主体是这样
    if (nums1[i] >= nums2[j]) {
        nums1[k] = nums1[i];
        i--;
    } else {
        nums1[k] = nums2[j];
        j--;
    }
    2. 考虑边界
        第一个分支 i越界 需要i>=0 变成 i >= 0 && nums1[i] >= nums2[j])
        第二个分支当j>=0的时候才会执行，那么写在上一个条件就是或者当j<0的时候i也会重新将值赋上

    第二种，指针修改，知道有一方跳出。  跳出之后如果是i=-1不需要修改，如果j=-1需要重新加上去
    比较简单的想法
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (j < 0 || (i >= 0 && nums1[i] >= nums2[j])) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums2[j] >= nums1[i]) {
                nums1[k] = nums2[j];
                j--;
            } else {
                nums1[k] = nums1[i];
                i--;
            }
            k--;
        }
        // 循环结束之后还需要 j有剩余
        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}
