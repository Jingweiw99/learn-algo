package com.wjw.doublePointer;

/*
接雨水
核心思路：遍历 1~ n-2 去填充每次需要的雨水 计算总和
for j  0 ~ i-1 找一个最大值  实际操作的过程中 不要每次遍历算，可以先算出结果来
for k i+1 n-1 找到一个最大值
两者取一个最小值
计算面积，然后加到res中
还有很多种解法，这个是比较好理解，很好写出来的。
 */
public class Lc42 {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n]; // leftMax[i] 表示i及其左边最大值
        for (int j = 0; j < n; j++) {
            if (j == 0) {
                leftMax[j] = height[0];
                continue;
            }
            leftMax[j] = Math.max(leftMax[j - 1], height[j]);
        }
        int[] rightMax = new int[n]; // rightMax[i] 表示i及其右边最大值
        for (int j = n - 1; j >= 0; j--) {
            if (j == n - 1) {
                rightMax[j] = height[n - 1];
                continue;
            }
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        int res = 0;
        for (int i = 1; i < n - 1; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Lc42 test = new Lc42();
        System.out.println(test.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));// 6
    }
}
