package com.wjw;

/*
将x减小到0 的最小操作数

转换为和为sum - x 的最长子数组
 */
public class Lc1658 {
    public static int minOperations(int[] nums, int x) {
        int n = nums.length, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        // 滑动窗口需要寻找的子数组目标和
        int target = sum - x;
        int left = 0, right = 0;
        int windowSum = 0; // 窗口中的所有元素和
        int maxLen = Integer.MIN_VALUE; // 记录目标子数组的最大长度
        while (right < nums.length) {
            windowSum += nums[right];
            right++;
            while (windowSum > target && left < right) {
                windowSum -= nums[left];
                left++;
            }
            if (windowSum == target) { // 缩减或者直接值等于目标，更新值
                maxLen = Math.max(maxLen, right - left);
            }
        }
        return maxLen == Integer.MIN_VALUE ? -1 : n - maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 4, 2, 3};
        int x = 5;
        int minOp = minOperations(nums, x);
    }
}
