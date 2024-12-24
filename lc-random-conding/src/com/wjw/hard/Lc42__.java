package com.wjw.hard;

/*
接雨水最优的解法
通过带有存储的最大值可以优化暴力解法，其实也能通过每次循环指针逼近的过程中走

while l < r
l_max
r_max
l++ r--
 */
public class Lc42__ {
    public int trap(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        int l_max = 0, r_max = 0;
        while (l < r) {
            l_max = Math.max(l_max, height[l]);
            r_max = Math.max(r_max, height[r]);
            if (l_max < r_max) {
                res += l_max - height[l];
                l++;
            } else {
                res += r_max - height[r];
                r--;
            }
        }
        return res;
    }
}
