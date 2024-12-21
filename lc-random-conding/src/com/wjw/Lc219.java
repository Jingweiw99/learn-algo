package com.wjw;

import java.util.HashMap;

/*
存在重复元素2

 */
public class Lc219 {
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        // 暴力解法超时了
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // 每次遍历都用hash表记录一下， 在put之前 先判断是否存在，如果存在，取出来，与当前i比较，如果小于等于k return true
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valToIndex.containsKey(nums[i])) {
                if (i - valToIndex.get(nums[i]) <= k) {
                    return true;
                } else {
                    valToIndex.put(nums[i], i);
                }
            } else {
                valToIndex.put(nums[i], i);
            }
        }
        return false;
    }
    // 优化结构后的代码
    public static boolean containsNearByDuplicate2(int[] nums, int k) {
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valToIndex.containsKey(nums[i]) && i - valToIndex.get(nums[i]) <= k) {
                return true;
            }
            valToIndex.put(nums[i], i);
        }
        return false;
    }
}
