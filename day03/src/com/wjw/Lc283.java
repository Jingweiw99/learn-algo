package com.wjw;

// 移动0 leetcode 283
public class Lc283 {
    /*
    这个思路是不等于0的时候往原素组里面添加，后面补0
     */
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        while (k < nums.length) {
            nums[k] = 0;
            k++;
        }
    }
}
