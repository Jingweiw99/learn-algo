package com.wjw.wordString;

/*
和为k的子数组
优化后的暴力解法
 */
public class Lc560_ {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int left = 0; left < nums.length; left++) {
            int sum = 0; // 前面计算了后面就不用计算了
            for (int right = left; right < nums.length; right++) {
                sum += nums[right];
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc560_ test = new Lc560_();
        System.out.println(test.subarraySum(new int[]{1, 2, 3}, 3));// 2
    }
}
