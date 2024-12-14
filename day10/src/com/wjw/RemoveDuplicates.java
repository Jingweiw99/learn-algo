package com.wjw;

/*
有序数组去重， 只留下一个
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        // 具体思路就是i遍历这个nums， 然后k指向需要修改的前一个值。 题目提示nums.length >=1
        int k = 0;
        // i = 1 ~ n-1  nums[i] 快指针与 慢nums[k]做比较，相等，不相等情况
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]) {
                k++;
                nums[k] = nums[i];
            }

        }
        return k + 1;
    }
}
