package com.wjw;

import java.util.HashMap;
import java.util.HashSet;

/*
单词规律
 */
public class Lc290 {
    public static boolean wordPattern(String pattern, String s) {
        String[] strArr = s.split(" ");
        char[] chars = pattern.toCharArray();
        if (strArr.length != chars.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            // 如果keys不包含c，那么put进去  如果包含了 对比值
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], strArr[i]);
                if (set.contains(strArr[i])) {
                    return false; // 这里只需要判断键，就优化成了set
                }
                set.add(strArr[i]);
                continue;
            }
            if (!map.get(chars[i]).equals(strArr[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String pattern = "abba", s = "dog cat cat dog";
        String pattern = "abba", s = "dog dog dog dog";
        boolean b = wordPattern(pattern, s);
        System.out.println(b);
    }
}
