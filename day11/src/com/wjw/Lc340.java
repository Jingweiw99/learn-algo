package com.wjw;

import java.util.HashMap;

public class Lc340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char rightVal = s.charAt(right);
            right++;
            window.put(rightVal, window.getOrDefault(rightVal, 0) + 1);
            while (left < right && window.size() > k) {
                char leftVal = s.charAt(left);
                left++;
                window.put(leftVal, window.get(leftVal) - 1);
                if (window.get(leftVal) == 0) window.remove(leftVal);
            }
            res = Math.max(res, right - left); // 这里一定会更新
        }
        return res;
    }
}
