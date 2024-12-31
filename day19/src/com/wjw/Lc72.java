package com.wjw;

/*
编辑距离
horse ros
只能删除 插入 替换 问最少需要操作多少次，将word1，转换为word2
 */
public class Lc72 {
    public int minDistance(String word1, String word2) {
        // 定义dp[i][j] 表示word1 [0,i] word2[0,j]的最小编辑距离
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1;
                }

            }
        }
        return dp[m][n];
    }

    private int min(int num1, int num2, int num3) {
        return Math.min(num1, Math.min(num2, num3));
    }

    public static void main(String[] args) {
        Lc72 test = new Lc72();
        System.out.println(test.minDistance("sea", "ate"));
    }
}
