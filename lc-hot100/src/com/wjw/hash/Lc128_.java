package com.wjw.hash;

import java.util.HashSet;
import java.util.Set;

/*
最长的连续序列
哈希表解法
 */
public class Lc128_ {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        for (int x : st) {
            // 如果包含了前面一个继续走，因为以前面的来走是更长的序列
            if (st.contains(x - 1)) continue;
            int y = x + 1;
            while (st.contains(y)) y++;
            // 循环结束后 y-1是最后一个数 x ~ y-1 一共有 y-x 个数
            res = Math.max(res, y - x);
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        Lc128_ test = new Lc128_();
        System.out.println(test.longestConsecutive(nums)); // 9
    }
}
