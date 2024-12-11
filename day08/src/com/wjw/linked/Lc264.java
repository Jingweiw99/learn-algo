package com.wjw.linked;

/*
找到第n个丑数


 */
public class Lc264 {
    public int nthUglyNumber(int n) {
        // 找到第n个丑数，使用动态规划 dp[n] 表示第n个丑数是dp[n]
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n];
    }
}
