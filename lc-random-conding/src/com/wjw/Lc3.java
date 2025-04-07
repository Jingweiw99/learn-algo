package com.wjw;

import java.util.HashMap;
import java.util.Map;

/*
无重复元素的最长字串的长度
枚举右段点
先获取这个值，添加到map中，如果这个值的值>1做左收缩 直到当前的=1
更新一下这里的最大值
 */
public class Lc3 {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Map<Character, Integer> cnt = new HashMap<>();
        int maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            while (cnt.get(c) > 1) {
                char c1 = s.charAt(left);
                cnt.put(c1, cnt.get(c1) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Lc3 test = new Lc3();
        System.out.println(test.lengthOfLongestSubstring(s)); //3
    }
}
