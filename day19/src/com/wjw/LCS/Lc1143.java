package com.wjw.LCS;

/*
最长公共的子序列
动态规划解法
 */
public class Lc1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        // i 1 ~ m   j 1 ~ n
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Lc1143 test = new Lc1143();
        System.out.println(test.longestCommonSubsequence("ezupkr", "ubmrapg"));//2 "oxcpqrsvwf" "shmtulqrypy" 但是没有考虑后面的情况， 只能暴力穷举全部的子序列，然后对比相等，找最大值
    }
}
