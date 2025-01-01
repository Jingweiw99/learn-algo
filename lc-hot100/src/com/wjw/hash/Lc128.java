package com.wjw.hash;

import java.util.Arrays;

/*
最长的连续序列
要求O(n)的时间复杂度
一个注意点就是 当相等的时候也需要跳过，只是最长序列不增
 */
public class Lc128 {
    // 采用排序 O(nlogn) 实际上力扣 这个方法还快一点
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        Arrays.sort(nums);
        int maxCnt = 1;
        int i = 0;
        while (i < n) {
            int cnt = 1;
            while (i + 1 < n && (nums[i] + 1 == nums[i + 1] || nums[i] == nums[i + 1])) {
                if (nums[i] + 1 == nums[i + 1]) {
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
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        Lc128 test = new Lc128();
        System.out.println(test.longestConsecutive(nums)); // 9
    }
}
