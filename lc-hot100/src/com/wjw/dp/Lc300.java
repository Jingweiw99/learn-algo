package com.wjw.dp;

import java.util.Arrays;

/*
最长递增的子序列
dp[i] 是以nums[i]结尾的最长递增子序列的长度为dp[i]
 */
public class Lc300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int lis = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] <= nums[j]) {
                    continue;
                }
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            lis = Math.max(dp[i], lis);
        }
        // 注意是以n-1结尾的 那不能返回n-1因为不一定是最后一个位置上才是最长的
        return lis;
    }

    public static void main(String[] args) {
        Lc300 test = new Lc300();
        System.out.println(test.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));// 4
    }
}
