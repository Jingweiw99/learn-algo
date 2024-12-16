package com.wjw;

import java.util.HashMap;

/*
s2是否包含s1的排列也就是说s1的排列之一是s2的子串 串 说明是连在一起的
 */
public class Lc567 {
    public boolean checkInclusion(String s1, String s2) {
        // 滑动窗口 什么时候收缩滑动窗口内包含了need
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        boolean isInclude = false;
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if(s1.length() == right - left) {
                    isInclude = true;
                }
                char c2 = s2.charAt(left);
                left++;
                if (need.containsKey(c2)) {
                    if (window.get(c2).equals(need.get(c2))) {
                        valid--;
                    }
                    window.put(c2, window.get(c2) - 1);
                }
            }
        }
        return isInclude;


    }
}
