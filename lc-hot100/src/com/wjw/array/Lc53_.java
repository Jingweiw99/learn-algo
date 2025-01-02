package com.wjw.array;

/*
最大的子数组和
暴力解法 这题会超时
这题可以多种解法，前缀和可以解决
优化之后我决定使用 动态规划 dp解法
定义dp[i] i = 0 ~ n - 1
表示以nums[i]结尾的最大子数组和为dp[i]
dp[0] = nums[0]
状态转移方程为
dp[i] = dp[i-1] + nums[i] dp[i-1]>=0
dp[i] = nums[i] dp[i-1]<0
 */
public class Lc53_ {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Lc53_ test = new Lc53_();
        System.out.println(test.maxSubArray(nums)); // 6
    }
}
