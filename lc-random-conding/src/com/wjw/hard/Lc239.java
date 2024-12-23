package com.wjw.hard;

import java.util.Arrays;

/*
滑动窗口的最大值

 */
public class Lc239 {
    // 暴力解 会超时
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            // i ~i + k - 1 中间的最大值
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                // 如果是大于更新小于等于继续
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            res[i] = max;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] maxSliding = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(maxSliding));
    }
}
