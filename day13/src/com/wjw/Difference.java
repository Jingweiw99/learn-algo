package com.wjw;

/*
差分数组的工具类
public int[] diff;
public Difference(int[] nums); // 初始化diff
public void increment(int l,int r,int val); // 修改diff
public int[]  result() // 由diff得到结果
 */
public class Difference {
    private int[] diff; // 差分数组

    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < diff.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    // l ~ r区间上加上val
    public void increment(int l, int r, int val) {
        diff[l] += val;
        if (r + 1 < diff.length) diff[r + 1] -= val;
    }

    // 由diff得到结果
    public int[] result() {
        int nums[] = new int[diff.length];
        nums[0] = diff[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i - 1] + diff[i];
        }
        return nums;
    }
}
