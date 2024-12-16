package com.wjw;

/*
长度最小的子数组
给一个数组nums，找到nums中最小的子数组，要求满足这个子数组和>=target
nums[i] > 0
返回最小子数组的长度
 */
public class Lc209 {
    public int minSubArrayLen(int target, int[] nums) {
        int windowSum = 0;
        int left = 0, right = 0;
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            windowSum += nums[right++];
            while (windowSum >= target && left < right) {
                res = Math.min(res, right - left);
                windowSum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
