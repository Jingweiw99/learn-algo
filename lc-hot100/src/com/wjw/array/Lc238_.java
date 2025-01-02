package com.wjw.array;

import java.util.Arrays;

/*
除自身以外的数组的乘积
核心思路：找到这个数的左边的乘积，找到右边的乘积 最后计算结果的时候只需要计算L[i] * R[i]
 */
public class Lc238_ {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        L[0] = 1;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        R[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = L[i] * R[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        Lc238_ test = new Lc238_();
        int[] arr = test.productExceptSelf(nums);
        System.out.println(Arrays.toString(arr));
    }
}
