package com.wjw;

import java.util.HashMap;

/*
s覆盖t的最小覆盖字串
 */
public class Lc76 {
    public static String minWindow(String s, String t) {
        // 大概思路就是给一个滑动窗口window去覆盖掉条件，然后收缩左侧
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        String res = null;
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        int valid = 0; // 当valid==need.size()的时候满足条件，开始收缩
        while (r < s.length()) {
            char c1 = s.charAt(r);
            r++;
            if (need.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (need.get(c1).equals(window.get(c1))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                String sSub = s.substring(l, r);
                res = res == null || res.length() > sSub.length() ? sSub : res;
//                System.out.printf("更新过的值res: %s, 对比的sSub: %s \n", res, sSub);
                char c2 = s.charAt(l);
                l++;
                if (need.containsKey(c2)) {
                    if (need.get(c2).equals(window.get(c2))) { // 这里细节先写这个if，不然有问题
                        valid--;
                    }
                    window.put(c2, window.get(c2) - 1);
                }
            }
        }
        return res;
    }

    // 优化时间，不需要每次都切割
    public static String minWindow2(String s, String t) {
        // 大概思路就是给一个滑动窗口window去覆盖掉条件，然后收缩左侧
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        String res = null;
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        int valid = 0; // 当valid==need.size()的时候满足条件，开始收缩
        int start = 0, len = Integer.MAX_VALUE;
        while (r < s.length()) {
            char c1 = s.charAt(r);
            r++;
            if (need.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1, 0) + 1);
                if (need.get(c1).equals(window.get(c1))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (len < r - l) {
                    start = l;
                    len = r - l;
                }
                char c2 = s.charAt(l);
                l++;
                if (need.containsKey(c2)) {
                    if (need.get(c2).equals(window.get(c2))) { // 这里细节先写这个if，不然有问题
                        valid--;
                    }
                    window.put(c2, window.get(c2) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s = minWindow2("AOBECBANC", "ABC"); // 结果更新过
        System.out.println(s); // CBA
    }
}
