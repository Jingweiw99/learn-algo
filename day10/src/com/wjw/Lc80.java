package com.wjw;

import java.util.Arrays;

/*
删除有序数组中的重复项2
删除有序数组中的重复项，出现次数大于等于2次的，只让出现两次

由于这个题目是有序的数组，那么可以不使用hashmap
 */
public class Lc80 {
    public static int removeDuplicates(int[] nums) {
        // 快慢指针 i快 k慢
        int k = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) cnt = 0;
            if (cnt < 2) {
                nums[k++] = nums[i];
                cnt++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int k = removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
}
