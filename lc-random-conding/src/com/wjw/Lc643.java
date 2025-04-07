package com.wjw;

/*
子数组的最大平均数
 */
public class Lc643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < k - 1)
                continue;
            maxSum = Math.max(maxSum, sum);
            sum -= nums[i - k + 1];
        }
        return (double) maxSum / k;
    }

}
