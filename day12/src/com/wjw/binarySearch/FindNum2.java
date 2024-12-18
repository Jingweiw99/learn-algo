package com.wjw.binarySearch;

/*
寻找左侧边界的二分搜索
普通的二分直接找到就返回了，我们需要再往左逼近一下

这里如果想要没找到返回-1就是判断当前的left是不是目标值，是返回left，不是返回-1 。
而且前面需要加上left是否越界了，left越界也是返回-1，因为我们要访问left
 */
public class FindNum2 {
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.printf("left: %d, right: %d \n", left, right);
        return left;
    }

    // 给一个right = nums.length的模板 搜索区间变为了[left, right)
    public static int binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.printf("left: %d, right: %d \n", left, right);
        return left;
    }

    // 给一个边界的搜索 没有找到返回-1
    public static int binarySearch3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left < 0 || left >= nums.length) return -1; // 其实这里left < 0可以省略，因为left都是+的不会往左走
        return nums[left] == target ? left : -1;
    }

    public static void main(String[] args) {
        // 找到的情况
//        int[] nums = {1, 2, 2, 2, 3};
//        int target = 2;
        // 没找到到返回的是什么呢？ 大于target的最小索引
        // 那么res-1就是小于目标值的最大索引，可以用来实现floor函数
        int[] nums = {1, 3, 3, 3, 4};
        int target = 2;
        int index = binarySearch2(nums, target);
        System.out.println(index);
    }

}
