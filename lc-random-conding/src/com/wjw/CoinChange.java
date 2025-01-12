package com.wjw;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        // dp[i]为 表示金额为i需要dp[i]枚硬币组成
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
