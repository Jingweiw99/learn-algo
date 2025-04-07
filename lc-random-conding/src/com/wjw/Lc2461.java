package com.wjw;

import java.util.HashMap;
import java.util.Map;

/*
长度为k的子数组的最大和
并且要求这k个数不相等

这里已经写对了， 可以通过getOrDefault来简化一下操作。
 */
public class Lc2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long max = 0;
        long sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer cur = nums[i];
            sum += cur;
            if (!cnt.containsKey(cur)) {
                cnt.put(cur, 1);
            } else {
                cnt.put(cur, cnt.get(cur) + 1);
            }
            if (i < k - 1)
                continue;
            if (cnt.size() == k) {
                max = Math.max(max, sum);
            }
            int removeVal = nums[i - k + 1];
            sum -= removeVal;
            if (cnt.get(removeVal) - 1 <= 0) {
                cnt.remove(removeVal);
            } else {
                cnt.put(removeVal, cnt.get(removeVal) - 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Lc2461 test = new Lc2461();
        int[] nums = {1, 5, 4, 2, 9, 9, 9};
        System.out.println(test.maximumSubarraySum(nums, 3));
    }
}
