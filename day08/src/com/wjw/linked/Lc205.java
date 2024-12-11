package com.wjw.linked;

import java.util.HashMap;

/*
同构字符串

 */
public class Lc205 {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        // 大体思路 paper -> title p -> t  通过hash表对应起来  这题需要反向也是对应起来， 我通过一个反向的hash表来记录
        HashMap<Character, Character> map = new HashMap<>();
        HashMap<Character, Character> reverseMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
                if (reverseMap.containsKey(t.charAt(i))) {
                    return false;
                } else {
                    reverseMap.put(t.charAt(i), s.charAt(i));
                }
                continue;
            }
            if (map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
