package com.wjw.hard;

/*
接雨水问题
暴力解法 会超时
能接多少水取决于左边最高柱子和右边最高柱子的最小值，减去height[i]
每次加等这个
water += Math.min(height[0,left], height[right, n-1]) - height[i]
height[0,left] 表示0-left最大值
 */
public class Lc42 {
    public int trap(int[] height) {
        int water = 0;
        int n = height.length;
        for (int i = 1; i < n - 1; i++) {
            int l_max = 0, r_max = 0;
            // i - 0
            for (int j = i; j >= 0; j--) {
                l_max = Math.max(l_max, height[j]);
            }
            // i - n - 1
            for (int j = i; j < n; j++) {
                r_max = Math.max(r_max, height[j]);
            }
            water += Math.min(l_max, r_max) - height[i];
        }
        return water;
    }
}
