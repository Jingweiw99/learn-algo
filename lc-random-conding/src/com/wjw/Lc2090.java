package com.wjw;

import java.util.Arrays;

/*
半径为k的子数组的平均值
如果不足 k 个返回-1
相当于定长为2k+1的数组
小于2k的时候开始添加过去，
等于2k的时候添加上这个值，计算平均值
最后移出的时候减去这个值就可以了。
 */
public class Lc2090 {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        long sum = 0; // 这里给long 不然最后一个测试用例会失效
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i < 2 * k)
                continue;
            res[i - k] = (int) (sum / (2 * k + 1));
            sum -= nums[i - 2 * k];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6}; // 23 + 9 = 32 32 / 7 = 4
        int k = 3;
        Lc2090 test = new Lc2090();
        int[] arrays = test.getAverages(nums, k);
        System.out.println(Arrays.toString(arrays));
    }
}
