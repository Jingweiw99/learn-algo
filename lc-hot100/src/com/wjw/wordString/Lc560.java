package com.wjw.wordString;

/*
和为k的子数组
暴力解法
 */
public class Lc560 {
    public int subarraySum(int[] nums, int k) {
        // 给left 遍历， 然后right=left 往后遍历，找到和为k的子数组结果res就+1
        int res = 0;
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                // 计算left-right的和
                int sum = 0;
                int i = left;
                while (i <= right) {
                    sum += nums[i++];
                }
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc560 test = new Lc560();
        System.out.println(test.subarraySum(new int[]{1, 2, 3}, 3));// 2
    }
}
