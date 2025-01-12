package com.wjw.dp;

import java.util.Arrays;

/*
完全平方数
 */
public class Lc279 {
    public int numSquares(int n) {
        // dp[i] 为数值为i 最少需要dp[i]个平方数 dp[n] = min{dp[n-i*1] + 1} i=1~n
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i - j * j < 0) break;
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Lc279 test = new Lc279();
        System.out.println(test.numSquares(12)); // 3
    }
}
