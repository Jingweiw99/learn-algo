package com.wjw.dp;

import java.util.Arrays;

/*
爬楼梯
每次可以爬一或者二，问n阶楼梯有多少种方法
 */
public class Lc70 {
    public int climbStairs(int n) {
        // dp[i] i阶楼梯可以有dp[i]种方法
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        Lc70 test = new Lc70();
        System.out.println(test.climbStairs(10));
    }
}
