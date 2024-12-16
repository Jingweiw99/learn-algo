package com.wjw;

/*
最大连续1的个数
给一个二进制数组，最多可以翻转k个0为1，求最长的1的个数
 */
public class Lc1004 {
    public static int longestOnes(int[] nums, int k) {
        // 窗口中的0小于等于k windowZeroSum 窗口中0 的个数
        int windowZeroSum = 0;
        int left = 0, right = 0;
        int maxLen = Integer.MIN_VALUE;
        while (right < nums.length) {
            if (nums[right] == 0) windowZeroSum += 1;
            right++;
            while (windowZeroSum > k) {
                if (nums[left] == 0) windowZeroSum -= 1;
                left++;
            }
            // 出来是小于等于k，我们要等于k的时候做一个更新
            if (windowZeroSum == k) {
                maxLen = Math.max(maxLen, right - left);
            }
        }
        return maxLen == Integer.MIN_VALUE ? nums.length : maxLen;
    }

    public static void main(String[] args) {
        //
//        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] nums = {0, 0, 0, 1}; // 这个情况就是直接没有走maxLen更新的情况，直接返回数组长度
        int maxLen = longestOnes(nums, 4);
        System.out.println(maxLen);
    }
}
