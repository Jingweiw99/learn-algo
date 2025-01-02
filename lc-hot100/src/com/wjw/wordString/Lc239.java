package com.wjw.wordString;

import java.util.Arrays;

/*
滑动窗口的最大值
取k个值，中的最大值放入到数组中
暴力  这个会超时
 */
public class Lc239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE; // 找到k个中的最大值
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc239 test = new Lc239();
        System.out.println(Arrays.toString(test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))); // [3,3,5,5,6,7]
    }
}
