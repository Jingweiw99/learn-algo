package com.wjw.maxSubArray;

/*
最大的子数组和
动态规划解法
 */
public class Lc53_ {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]); // 要么与前面连接，要么自己
        }
        int res = Integer.MIN_VALUE;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }

    public static void main(String[] args) {
        Lc53_ test = new Lc53_();
        System.out.println(test.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
    }
}
