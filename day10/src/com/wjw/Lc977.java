package com.wjw;

import java.util.Arrays;

/*
有序数组的平方
思路：头尾都给一个指针，然后平方相当于是两个从大到小的数组  需要返回新数组
如果都是非负数其实可以特判，但是也满足条件
 */
public class Lc977 {
    public static int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int l = 0, r = nums.length - 1, p = r;
        while (r >= l) {// 或者说遍历一次p p    r >= l  或者 p>=0都是满足情况的
            if (Math.abs(nums[r]) >= Math.abs(nums[l])) {
                arr[p] = nums[r] * nums[r];
                r--;
            } else {
                arr[p] = nums[l] * nums[l];
                l++;
            }
            p--;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 1, 2, 3, 5};
        int[] arr = sortedSquares(nums);
        System.out.println(Arrays.toString(arr));
    }
}
