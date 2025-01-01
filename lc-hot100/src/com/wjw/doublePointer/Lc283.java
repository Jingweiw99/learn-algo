package com.wjw.doublePointer;

import java.util.Arrays;

/*
移动0
将0移动到最后，同时其他元素相对位置不变
 */
public class Lc283 {
    public void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果不是0 赋值给k k++
            if (nums[i] != 0) {
                nums[k] = nums[i];
                k++;
            }
        }
        // k nums.length-1
        while (k < nums.length) {
            nums[k] = 0;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 0};
        Lc283 test = new Lc283();
        test.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
