package com.wjw;

/*
分割数组的最大值

给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组，使得这 k 个子数组各自和的最大值 最小。
 */
public class Lc410 {
    public static int splitArray(int[] nums, int k) {
        int left = 0, right = 1;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midVal = cnt(nums, mid);
            if (midVal <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // x 的可能取值就是最大值的最小值
    // 对应的x 计算出的结果是需要多少次分割 k
    private static int cnt(int[] nums, int x) {
        int k = 0;
        int i = 0;
        while (i < nums.length) {
            int x1 = x;
            while (i < nums.length) {
                if (x1 - nums[i] < 0)
                    break;
                x1 -= nums[i];
                i++;
            }
            k++;
        }
        return k;
    }

    public static void main(String[] args) {
//        int[] nums = {7, 2, 5, 10, 8};
//        int k = 2;
        int[] nums = {5, 2, 4, 1, 3, 6, 0};
        int k = 4;
        System.out.println(splitArray(nums, k)); // 18
    }
}
