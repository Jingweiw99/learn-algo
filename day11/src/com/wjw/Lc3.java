package com.wjw;

import java.util.HashMap;

/*
无重复的最长子串

 */
public class Lc3 {
    public static int lengthOfLongestSubstring(String s) {
        // 滑动窗口 有重复的char了左窗口滑动
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            while (window.get(c) > 1) {
                char c1 = s.charAt(left);
                left++;
                window.put(c1, window.get(c1) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        int cnt = lengthOfLongestSubstring("abcabcbb");
        System.out.println(cnt);
    }
}
