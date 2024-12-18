package com.wjw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
异位词分组
 */
public class Lc49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> strToList = new HashMap<>();
        for (String s : strs) {
            // 如果这个s排序之后是不包含，就添加string，List
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            if (strToList.containsKey(sortedStr)) {
                strToList.get(sortedStr).add(s);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s);
                strToList.put(sortedStr, list);
            }
        }
        return new ArrayList<List<String>>(strToList.values()); // ArrayList可以传Collection
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
