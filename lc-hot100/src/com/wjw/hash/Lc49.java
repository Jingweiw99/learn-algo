package com.wjw.hash;

import java.util.*;

/*
字母的异位词分组
 */
public class Lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(str);
            map.put(s, list);
        }
//        List<List<String>> res = new ArrayList<>();
//        for (List<String> value : map.values()) {
//            res.add(value);
//        }
//        return res;

        return new ArrayList<List<String>>(map.values());
    }

    public static void main(String[] args) {
        Lc49 test = new Lc49();
        System.out.println(test.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
