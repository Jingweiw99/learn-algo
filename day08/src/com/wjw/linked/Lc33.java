package com.wjw.linked;

import java.util.HashMap;
import java.util.Map;

public class Lc33 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }
            Integer cVal = map.get(c);
            if (cVal - 1 <= 0) {
                map.remove(c);
            } else {
                map.put(c, cVal - 1);
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (map.getOrDefault(c, 0) <= 0) {
                return false;
            }
            Integer cVal = map.get(c);
            map.put(c, cVal - 1);
        }
        return true;
    }
}
