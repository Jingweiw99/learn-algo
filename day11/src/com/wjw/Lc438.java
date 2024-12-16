package com.wjw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Lc438 {
    public static List<Integer> findAnagrams(String s, String p) {
        // 滑动窗口记录 每个字符出现的次数 need记录需要的次数
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0; // 字符对应的数字相等的时候++
        List<Integer> res = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 当我们的滑动窗口的长度大于等于 p.length() 需要进行收缩，收缩之前判断
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    System.out.printf("left: %d, right: %d , valid: %d, window.size(): %d  \n", left, right, valid, window.size());
                    res.add(left);
                }
                char c1 = s.charAt(left);
                left++;
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> list = findAnagrams("cbaebabacd", "abc");
        System.out.println(list);
    }
}
