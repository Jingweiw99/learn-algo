package com.wjw.binarySearch;

/*
寻找一个数
最基本的二分搜索 Lc104 二分搜索

只能找到对应的索引，我们需要不能保证是最左的或者最右的 比如{1,2,2,2,3} 我们需要找到2 这里直接返回的是索引2
 */
public class FindNum {
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        System.out.printf("left: %d, right: %d \n", left, right);
        return -1;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5, 6};
//        int target = 4;
        int[] nums = {1, 2, 3, 5, 6};
        int target = 4;
        int idx = binarySearch(nums, target);
        System.out.println(idx);
    }
}
