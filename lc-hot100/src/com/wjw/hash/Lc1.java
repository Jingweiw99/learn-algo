package com.wjw.hash;

import java.util.Arrays;
import java.util.HashMap;

/*
两数之和
 */
public class Lc1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 8, 9};
        int target = 9;
        Lc1 test = new Lc1();
        System.out.println(Arrays.toString(test.twoSum(nums, target)));
    }
}
