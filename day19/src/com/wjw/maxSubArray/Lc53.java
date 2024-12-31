package com.wjw.maxSubArray;

/*
最大的子数组和
前缀和解法
 */
public class Lc53 {
    public int maxSubArray(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < preSum.length; i++) {
            // 前j项和求一个最大 比较暴力的解法了
            for (int j = i + 1; j < preSum.length; j++) {
                maxSum = Math.max(maxSum, preSum[j] - preSum[i]);
            }
        }
        return maxSum;
    }

    // 优化一下 滑动的时候同时记住前面的最小值
    public int maxSubArray2(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int maxSum = Integer.MIN_VALUE;
        int preMin = Integer.MAX_VALUE;
        for (int i = 0; i < preSum.length; i++) {
            preMin = Math.min(preMin, preSum[i]);
            maxSum = Math.max(maxSum, preSum[i] - preMin);
        }
        return maxSum;
    }


    public static void main(String[] args) {
        Lc53 test = new Lc53();
        System.out.println(test.maxSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})); // 6
    }
}
