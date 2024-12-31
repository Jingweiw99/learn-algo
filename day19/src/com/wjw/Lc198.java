package com.wjw;

/*
打家劫舍
思考过程：
如果只有1家，金额就为这家，如果两家 金额为这两家取大的值
定义dp[i] 表示第i家能获取的最大金额 i = 0 ~ n
如果有3家及以上
1. 前面一家没打劫 dp[i] = dp[i-2] + nums[i-1];
2. 前面一家打劫   dp[i] = dp[i-1]
 */
public class Lc198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[1] = nums[0];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i - 1], dp[i - 1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Lc198 test = new Lc198();
        System.out.println(test.rob(new int[]{2, 1, 1, 2})); // 4
        System.out.println(test.rob(new int[]{1, 2})); // 2
    }
}
