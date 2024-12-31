package com.wjw;

import java.util.Arrays;

/*
零钱兑换
 */
public class Lc322 {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示金额为 i的时候，最少需要 dp[i]枚硬币
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i < coins[j]) continue;
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Lc322 test = new Lc322();
        System.out.println(test.coinChange(new int[]{1, 2, 5}, 11)); // 3
    }
}
