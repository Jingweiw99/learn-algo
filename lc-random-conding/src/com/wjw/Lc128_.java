package com.wjw;

import java.util.HashSet;

/*
最长连续序列
O（n）解法
 */
public class Lc128_ {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxCnt = 0;
        // 找到一个数，如果这个数没有一个数比它小1，那么这个是最开头的数
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int cnt = 1;
            while (set.contains(num + 1)) {
                cnt++;
                num++;
            }
            maxCnt = Math.max(maxCnt, cnt);
        }
        return maxCnt;
    }

    public static void main(String[] args) {
        Lc128 test = new Lc128();
        int maxLen = test.longestConsecutive(new int[]{1, 2, 0, 1});
        System.out.println(maxLen);
    }
}
