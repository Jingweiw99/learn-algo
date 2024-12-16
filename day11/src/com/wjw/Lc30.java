package com.wjw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc30 {
    // TODO: 这题有难度，需要多看看
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        int m = words.length, n = words[0].length(), ls = s.length();
        // 每个words的word i 从单词 0 ~ n-1才能扫描全部情况
        for (int i = 0; i < n; i++) {
            if (i + m * n > ls) {
                break;
            }
            Map<String, Integer> differ = new HashMap<String, Integer>(); // 截取的单词和窗口中的差
            // 每个单词的索引 j
            for (int j = 0; j < m; j++) {
                String word = s.substring(i + j * n, i + (j + 1) * n);
                differ.put(word, differ.getOrDefault(word, 0) + 1);
            }
            for (String word : words) {
                differ.put(word, differ.getOrDefault(word, 0) - 1);
                if (differ.get(word) == 0) {
                    differ.remove(word);
                }
            }
            // 这里范围的界定 start 找m*n 到达ls的长度 是索引ls-m * n, i开始 start = i ~ ls - m * n  每个单词开始移动
            for (int start = i; start < ls - m * n + 1; start += n) {
                if (start != i) { // 每次i首次进入不走这个
                    String word = s.substring(start + (m - 1) * n, start + m * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                    word = s.substring(start - n, start);
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }
                if (differ.isEmpty()) { // 对比正好，添加进去
                    res.add(start);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"foo", "bar", "the"};
        List<Integer> list = findSubstring("barfoofoobarthefoobarman", words);
    }
}
