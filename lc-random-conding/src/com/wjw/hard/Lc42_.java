package com.wjw.hard;

/*
接雨水问题
暴力解优化

暴力解法在计算左侧最大值的时候每次都遍历计算
可以事先给一个结果集，  类似与dp 找到i位置的左侧的最大值，相当于等于当前的值与当前前面一个的最大值的最大值比较
left[i] 表示i左侧(包括i)的最大值  left[0] = height[0] 数组长度n
right[i] 表示i右侧的最大值  right[n-1] = height[n-1]
for 1 - n-1  每一次 left[i] = Math.max(left[i-1], height[i]);
for n-2 - 0        right[i] = Math.max(right[i+1], height[i]);

下面就与暴力解法一样了
for 1 - n-2 每一次 res += Math.min(left[i] - right[i]) - height[i];
 */
public class Lc42_ {
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        int[] left = new int[n];
        left[0] = height[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        int[] right = new int[n];
        right[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}
