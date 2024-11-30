package com.wjw.binarySearch;

/*
基础版本binarySearch
细节 为什么right是nums.length -1 可不可以是 nums.length 如果是nums.length 那么我们while的时候不要有等号
有了 为什么需要有等号， 因为搜索的时候我们没有写等号的情况当遇到left==right的时候就退出了没有搜索对比到当前的mid，这是不行的。
然后left + (right - left) / 2这是防止int出界。


一下的左右边界算法其实返回的时候 left left-1
也可以在找不到的时候返回-1
最后判断是否是相等的，如果是相等的直接返回原来的返回值，
如果是不相等的直接返回-1
在这个判断nums[left] nums[left-1]的过程中需要判断是否越界了，最简单的方式就是直接判断是否是>=0 <=nums.length-1;
 */
public class BinarySearch {
    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    // 寻找左界边界的二分搜索
    /*
    如果搜索不存在这里返回的left值得是什么？  大于target的值最小索引

    一下代码分支判断可以自行简化，这样写比较好理解
     */
    public static int binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid; // right是有边界，并且永远取不到
            }
        }
        return left;
    }

    // 如果是普通的左闭右闭的区间
    public static int binarySearch3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                // 大于或者等于的时候其实都需要往左搜索
                right = mid - 1;
            }
        }
        return left;
    }

    // 寻找到右边界的二分查找
    public static int binarySearch4(int[] nums, int target){
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1; // 最后是这个退出条件 或者是下面那个分支的退出条件所有最后返回的时候是返回mid 也就是left - 1
            } else if (nums[mid] < target) {
                left = mid + 1; // 如果最后不存在那么最后的退出结果left-1是小于target的最大值的最右边
            } else if (nums[mid] > target) {
                right = mid; // right是有边界，并且永远取不到
            }
        }
        return left - 1;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,4,5,6};
//        int[] nums = {1, 2, 3, 3, 4, 5, 6};
//        int i = binarySearch(nums, 3);
//        System.out.println(i);

        int[] nums = {1, 2, 3, 3, 4, 5, 6};
//        int i = binarySearch2(nums, 3);
//        int i = binarySearch3(nums, 3);
        int i = binarySearch4(nums, 3);

        System.out.println(i);
    }
}
