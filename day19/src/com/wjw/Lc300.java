package com.wjw;

import java.util.Arrays;

/*
最长递增子序列 LIS

 */
public class Lc300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length]; // dp[i]代表num[i]结尾的最长递增子序列的长度
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            // 0 ~ i-1 上找比nums[i]小的nums[j] 然后更新dp
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int num : dp) {
            if (res < num) res = num;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc300 test = new Lc300();
        System.out.println(test.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3})); // 4
    }
}
