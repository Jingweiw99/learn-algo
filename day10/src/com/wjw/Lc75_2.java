package com.wjw;

import java.util.Arrays;

/*
颜色分类第二种解法 采用快慢+双指针
可以只用遍历一次
 */
public class Lc75_2 {
    public static void sortColors(int[] nums) {
        int i = 0, l = 0, r = nums.length - 1;
        while (r >=  i) {
            if (nums[i] == 0) {
                swap(nums, l, i);
                l++;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r--;
            } else if (nums[i] == 1) {
                i++;
            }

            if (i < l) {
                i = l;
            }
        }
    }

    private static void swap(int[] nums, int l, int i) {
        int temp = nums[l];
        nums[l] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {1,1,0,2,1,0};
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
