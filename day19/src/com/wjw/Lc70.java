package com.wjw;

/*
爬楼梯
 */
public class Lc70 {
    public int climbStairs(int n) {
        // 定义dp[i] 为 爬i阶楼梯有dp[i]种方式 dp[i] = dp[i-1] + dp[i-2]
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
