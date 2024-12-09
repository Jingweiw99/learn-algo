package com.wjw.dp;

import java.util.Arrays;

/*
凑零钱问题

 */
public class Lc322 {
    // coins 中是可选硬币面值，amount 是目标金额
    public static void main(String[] args) {
        Lc322 test = new Lc322();
        int count = test.coinChange(new int[]{1, 2, 10}, 11);
        System.out.println(count);

        System.out.println(test.coinChange3(new int[]{1, 2, 5}, 11));

    }

    // 暴力解
    int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1; // 这里是防止初始进入就小于0 的情况
        if (amount == 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin < 0) continue;
            int cc = coinChange(coins, amount - coin);
            min = Math.min(cc, min);
        }
        return min == Integer.MAX_VALUE ? -1 : min + 1;
    }

    // 带有备忘录的递归
    int coinChange2(int[] coins, int amount) {
        // 记录dp[i] 表示 i的钱最少需要多少枚dp[i]个硬币 dp[11] = 3 表示amount 11 情况下最少需要3枚硬币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1111);
        int cnt = d(coins, amount, dp);
        return cnt;
    }

    // min{d(coins, amount - coin, dp), d(coins, amount - coin2, dp) ...}  + 1
    private int d(int[] coins, int amount, int[] dp) {
        if (amount < 0) return -1; // 这里是防止初始进入就小于0 的情况
        if (amount == 0) return 0;
        if (dp[amount] != -1111) return dp[amount];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            min = Math.min(d(coins, amount - coin, dp), min);
            dp[amount] = min + 1;
        }
        return dp[amount];
    }

    // dp数组的迭代解法 或者叫做递推 dp[n] = min{dp[n - coin1], dp[n - coin2] ...} + 1
    // 找不到需要返回-1
    int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);// 第一步比较的时候需要用到
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            // dp[n] = min{dp[n-coin1],dp[n-coin2]...} + 1
            for (int coin : coins) {
                if (i - coin < 0)
                    continue; // 无解找下一硬币
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
