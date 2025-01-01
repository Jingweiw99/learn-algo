package com.wjw.doublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
三数之和
注意 i j k 都是可以重复的，走了之后判断还能不能走。
走后面判断与前面是否相等， 走前面判断和后面是否相等。
 */
public class Lc15 {
    // 双指针暴力解
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i <= n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    j++;
                    k--;
                    while (j < k && nums[j - 1] == nums[j]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                    while (j < k && nums[j - 1] == nums[j]) j++;
                } else {
                    k--;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, -1, -1, 0, 1, -4};
        Lc15 test = new Lc15();
        System.out.println(test.threeSum(nums));
        System.out.println(test.threeSum(new int[]{-2, 0, 0, 2, 2}));
    }
}
