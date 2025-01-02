package com.wjw.array;

import java.util.Arrays;

/*
除自身以外的数组的乘积
暴力解法  这题也是超时
 */
public class Lc238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int num = 1;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                num *= nums[j];
            }
            res[i] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 1, 0, -3, 3};
        Lc238 test = new Lc238();
        int[] arr = test.productExceptSelf(nums);
        System.out.println(Arrays.toString(arr));
    }
}
