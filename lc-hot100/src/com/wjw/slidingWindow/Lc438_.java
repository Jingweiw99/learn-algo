package com.wjw.slidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
找到字符串的异位词
 */
public class Lc438_ {
    public List<Integer> findAnagrams(String s, String p) {
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < p.length(); i++) {
            ++pArr[p.charAt(i) - 'a'];
        }
        for (int right = 0; right < s.length(); right++) {
            ++sArr[s.charAt(right) - 'a'];
            int left = right - p.length() + 1;
            if (left < 0) {
                continue;
            }
            if (Arrays.equals(sArr, pArr)) {
                res.add(left);
            }
            --sArr[s.charAt(left) - 'a'];
        }
        return res;
    }

    public static void main(String[] args) {
        Lc438_ test = new Lc438_();
        System.out.println(test.findAnagrams("cbaebabacd", "abc")); // [0, 6]
//        System.out.println(test.findAnagrams("baa", "aa")); // [1]
    }
}
