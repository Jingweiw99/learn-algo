package com.wjw;

/*
原地删除等于val的值，前k个不等于val，返回k的值
 */
public class Lc27 {
    // 原地删除等于val的值，前k个不等于val，返回k的值
    public int removeElement(int[] nums, int val) {
        int k = 0, i = 0; // i快指针，k慢指针
        while (k < nums.length) {
            if (nums[k] == val) {
                // 找到当前的i后面的不等于val的索引
                while (i < nums.length && nums[i] == val) {
                    i++;
                }
                if (i >= nums.length) {
                    return k;
                }
                // k i 的值替换
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;
            }
            k++;
            i++;
        }
        return k;
    }
}
