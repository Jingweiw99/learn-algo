package com.wjw.wordString;

import java.util.HashMap;

/*
最小覆盖字串
 */
public class Lc76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0; // 当valid == tMap.size() 这个时候说明满足条件
        int resLeft = -1;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            // 需要的字符串和 窗口中的字符串对应上 也就是每个字符 对应的数相等
            if (tMap.containsKey(c)) {
                sMap.put(c, sMap.getOrDefault(c, 0) + 1);
                if (tMap.get(c).equals(sMap.get(c))) {
                    valid++;
                }
            }
            while (valid == tMap.size()) {
                if (right - left < len) {
                    resLeft = left;
                    len = right - left;
                }
                char c1 = s.charAt(left);
                left++;
                if (tMap.containsKey(c1)) {
                    if (tMap.get(c1).equals(sMap.get(c1))) {
                        valid--;
                    }
                    sMap.put(c1, sMap.get(c1) - 1);
                }
            }
        }
        return resLeft == -1 ? "" : s.substring(resLeft, resLeft + len);
    }

    public static void main(String[] args) {
        Lc76 test = new Lc76();
        System.out.println(test.minWindow("abobecodebanc", "abc")); // banc
    }
}
