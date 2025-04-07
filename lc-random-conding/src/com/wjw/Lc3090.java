package com.wjw;

import java.util.HashMap;
import java.util.Map;

/*
每个字符最多出现两次的最长子字符串的长度
新加入的最变成超过两个
 */
public class Lc3090 {
    public int maximumLengthSubstring(String s) {
        int left = 0, right = 0;
        Map<Character, Integer> cnt = new HashMap<>();
        int maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            while (cnt.get(c) > 2) {
                char c1 = s.charAt(left);
                cnt.put(c1, cnt.get(c1) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }
}
