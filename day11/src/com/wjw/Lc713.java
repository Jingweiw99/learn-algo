package com.wjw;

/*
找到nums中的严格小于k的连续子序列的数量
 */
public class Lc713 {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        // 这题用滑动窗口写 windowSum记录乘积，
        // windowSum < k的时候扩大 windowSum >= k 的时候缩小 满足条件出来就可以更新结果了
        int windowSum = 1;
        int left = 0, right = 0;
        int resCnt = 0;
        while (right < nums.length) {
            windowSum *=  nums[right];
            right++;
            while (windowSum >= k && left < right) {
                windowSum /= nums[left];
                left++;
            }
//            System.out.printf("left: %d, right: %d \n", left, right);
            resCnt += right - left;
        }
        return resCnt;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int cnt = numSubarrayProductLessThanK(nums, 100);
        System.out.println("结果cnt = " + cnt);
    }
}
