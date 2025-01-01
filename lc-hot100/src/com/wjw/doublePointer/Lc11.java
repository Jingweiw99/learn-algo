package com.wjw.doublePointer;

/*
盛水最多的容器
核心思路： 给两个指针 left right 想中间移动， 面积由最低的那一个决定， 然后计算并更新盛水面积之后，移动短的那根水柱。
能盛水的面积为
 */
public class Lc11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                max = Math.max(height[left] * (right - left), max);
                left++;
            } else {
                max = Math.max(height[right] * (right - left), max);
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Lc11 test = new Lc11();
        System.out.println(test.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
    }
}
