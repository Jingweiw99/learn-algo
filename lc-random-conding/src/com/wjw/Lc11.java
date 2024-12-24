package com.wjw;

/*
盛水最多的容器

while(l < r)
双指针中间滑动
盛水的区域面积为
 (r - l) *  Math.min(height[l],height[r])
每次更新最大值   res
 */
public class Lc11 {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
