package com.wjw;

import java.util.Arrays;
import java.util.HashMap;

/*
是否是有效的异位词

两种方式思维方式不一致，但是事件复杂度都是一样的
 */
public class Lc242 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            // 如果map不包含c false 如果包含了 次数-1
            if (!map.containsKey(c)) {
                return false;
            }
            map.put(c, map.get(c) - 1);
            if (map.get(c).equals(0)) {
                map.remove(c);
            }
        }
//        return map.size() != 0 ? false : true; // 这里可以不用判断size了
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            // 进来就减，小于0说明是不包含，或者次数小于s里面的 直接返回false。
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }

    // 如果是异位词，说明，排序之后的是equals true的  这个是最高效的
    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
//        String s1 = new String(sChars);
//        String t1 = new String(tChars);
//        return s1.equals(t1) ? true : false;
        return Arrays.equals(sChars, tChars);
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
//        String s = "cat", t = "rat";
//        String s = "aacc", t = "ccac";
        System.out.println(isAnagram3(s, t));
    }
}
