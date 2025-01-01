package com.wjw.wordString;

/*
和为k的子数组
一个区间的和
想到用前缀和数组来解   和第二种暴力时间复杂度上没啥区别
 */
public class Lc560__ {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = 0; i < n + 1; i++) {
            for (int j = i+1; j < n + 1; j++) {
                if (preSum[j] - preSum[i] == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc560__ test = new Lc560__();
        System.out.println(test.subarraySum(new int[]{1, 2, 3}, 3));// 2
    }
}
