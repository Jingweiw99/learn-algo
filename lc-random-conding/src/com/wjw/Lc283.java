package com.wjw;

import java.util.Arrays;

/*
移动0，将0移动到数组的末尾，并保持其他元素的相对位置不变
核心思路：不等于0的往k上放，最后给k补0
 */
public class Lc283 {
    public void moveZeroes(int[] nums) {
        int k = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        // k ~ n-1 开始全部补0
        while (k < n) {
            nums[k++] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Lc283 test = new Lc283();
        test.moveZeroes(nums);
        System.out.println(Arrays.toString(nums)); // {1,3,12,0,0}
    }
}