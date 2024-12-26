package com.wjw;

import java.util.Arrays;

/*
最长连续序列
 */
public class Lc128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return nums.length;
        Arrays.sort(nums);
        int maxCnt = 1;
        int i = 0;
        while (i < nums.length) {
            int cnt = 1;
            while (i + 1 < nums.length && (nums[i] == nums[i + 1] - 1 || nums[i] == nums[i + 1])) {
                if (nums[i] == nums[i + 1] - 1) {
                    cnt++;
                    maxCnt = Math.max(maxCnt, cnt);
                }
                i++;
            }
            i++;
        }
        return maxCnt;
    }

    public static void main(String[] args) {
        Lc128 test = new Lc128();
        int maxLen = test.longestConsecutive(new int[]{1, 2, 0, 1});
        System.out.println(maxLen);
    }
}
