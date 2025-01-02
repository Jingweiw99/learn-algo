package com.wjw.array;

/*
最大的子数组和
暴力解法 这题会超时
 */
public class Lc53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int right = 0; right < n; right++) {
            for (int left = 0; left <= right; left++) {
                int i = left;
                int sum = 0;
                while (i <= right) {
                    sum += nums[i];
                    i++;
                }
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Lc53 test = new Lc53();
        System.out.println(test.maxSubArray(nums)); // 6
    }
}
