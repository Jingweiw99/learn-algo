package com.wjw;

/*
最长回文子序列
dp[i][j] 表示s在[i,j]的最长回文子序列的长度
初始条件每一个都是回文子序列因此 当i == j 的时候都是1
i < j的时候
计算dp数组
状态转移方程为
dp[i][j] = dp[i+1][j-1] + 2 s i位置和j位置相等
dp[i][j] = max{ dp[i][j-1], dp[i+1][j]}
 */
public class Lc516 {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // i = n-2 ~ 0  j = i+1 ~ n-1
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Lc516 test = new Lc516();
        System.out.println(test.longestPalindromeSubseq("acbea")); // 3
    }

}
