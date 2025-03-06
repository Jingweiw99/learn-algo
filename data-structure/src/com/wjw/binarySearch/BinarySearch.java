package com.wjw.binarySearch;

/*
前提是二分查找的数组是有序的
二分查找 一个数，如果找到返回对应的索引，找不到返回-1 无重复
二分查找 一个数，查找到它的左边界 有重复数字
二分查找 一个数，查找到它的右边界 有重复数字

核心思路： 给左边界，右边界 然后每次获取中间的数， 如果目标的数 与 中间的数 比较
 */
public class BinarySearch {
    // 搜索索引的二分查找
    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = nums[mid];
            if (target == val) {
                return mid;
            } else if (target > val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int binarySearchLeft(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 在这里如果是小于或者等于target 还需要向左搜索
            int val = nums[mid];
            if (target <= val) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 搜索右边界是一样的 当nums[mid] >= target的时候还需要向右搜索
    public int binarySearchRight(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int val = nums[mid];
            if (target >= val) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }


    public static void main(String[] args) {
        test3();
    }

    public static void test1() {
        int[] nums = {1, 2, 3, 4, 5};
        BinarySearch test = new BinarySearch();
        System.out.println(test.binarySearch(nums, 4));// 3
    }

    public static void test2() {
        int[] nums = {1, 2, 3, 3, 4, 5};
        BinarySearch test = new BinarySearch();
        System.out.println(test.binarySearchLeft(nums, 3)); // 2
    }

    public static void test3() {
        int[] nums = {1, 2, 3, 3, 4, 5};
        BinarySearch test = new BinarySearch();
        // 分析一下这个右边界的返回的right意思是什么？？？

        System.out.println(test.binarySearchRight(nums, 3)); // 3
    }
}
