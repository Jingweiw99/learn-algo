package com.wjw.dp;

import java.util.Arrays;

/*
零钱兑换
 */
public class Lc322 {
    public int coinChange(int[] coins, int amount) {
        // dp[i] i至少需要dp[i]枚凑齐
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 10001); // 这里看题目的要求，   dp[i - coin] + 1 这里要+1不能设置为int的最大值
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == 10001 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Lc322 test = new Lc322();
        System.out.println(test.coinChange(new int[]{2}, 3)); // -1
    }
}
