package com.wjw.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
找到字符串中的所有字母异位词
这里两个contains里面是相反的 这里注意一下
 */
public class Lc438 {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            need.put(p.charAt(i), need.getOrDefault(p.charAt(i), 0) + 1);
        }
        int n = s.length();
        int left = 0, right = 0;
        int valid = 0;
        List<Integer> res = new ArrayList<>();
        while (right < n) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
//            System.out.printf("left: %d, right: %d \n", left, right);
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                char c1 = s.charAt(left);
                if (need.containsKey(c1)) {
                    if (window.get(c1).equals(need.get(c1))) {
                        valid--;
                    }
                    window.put(c1, window.get(c1) - 1);
                }
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc438 test = new Lc438();
        System.out.println(test.findAnagrams("cbaebabacd", "abc")); // [0, 6]
        System.out.println(test.findAnagrams("baa", "aa")); // [1]
    }
}
