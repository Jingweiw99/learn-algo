package com.wjw.slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
无重复字符的最长字串
左闭右开，记住 比如截取字符串，截取的长度就是right - left
 */
public class Lc3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>(); // 字符出现的次数
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            map.put(c, map.getOrDefault(c, 0) + 1);
            // 判断是否重复了
            while (map.get(c) > 1) {
                char c1 = s.charAt(left);
                map.put(c1, map.get(c1) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Lc3 test = new Lc3();
        System.out.println(test.lengthOfLongestSubstring("pwwkew")); // 3
    }
}
