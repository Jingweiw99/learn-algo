package com.wjw;

/*
区域和检索
直接通过left ~ right 相加，效率比较低，我们先求出前缀和数组，然后计算就效率高多了。
 */
public class NumArray {
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    // 这里是索引left ~ right
    public int sumRange(int left, int right) {
        return sum[right + 1] - sum[left];
    }
}
