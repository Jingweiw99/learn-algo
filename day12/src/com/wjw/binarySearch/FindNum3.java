package com.wjw.binarySearch;

/*
找到右界的二分搜索

找不到的时候  小于目标值的最大索引
找到的时候    对应的索引

如果有一个题目是找到左右边界，那么调用2里面的方法，调用3的方法，然后组成数组返回既可。
 */
public class FindNum3 {
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.printf("left: %d, right: %d \n", left, right);
        return left - 1; // 或者是right 因为退出条件是left = right + 1
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 2, 2, 4};
//        int target = 2;
        int[] nums = {1, 3, 3, 3, 4};
        int target = 2;
        int index = binarySearch(nums, target);
        System.out.println(index);
    }
}
