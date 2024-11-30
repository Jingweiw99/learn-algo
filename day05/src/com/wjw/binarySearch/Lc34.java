package com.wjw.binarySearch;

public class Lc34 {
    public int[] searchRange(int[] nums, int target) {
        return new int[] { left_bound(nums, target), right_bound(nums, target) };
    }

    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 检查边界
        if (left < 0 || left >= nums.length || target != nums[left]) {
            return -1;
        }
        // 不在边界或者不相等的时候都是-1
        return left;
    }

    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target >= nums[mid]) {
                left = mid + 1;
            }
        }
        // 检查右边界
        if (right < 0 || right >= nums.length || target != nums[right]) {
            return -1;
        }
        return right; // or left - 1
    }
}
