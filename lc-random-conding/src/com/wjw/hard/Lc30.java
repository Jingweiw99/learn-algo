package com.wjw.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
串联所有单词的字串
 */
public class Lc30 {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> needMap = new HashMap<>();
        for (String word : words) {
            needMap.put(word, needMap.getOrDefault(word, 0) + 1);
        }
        int oneWordLen = words[0].length();
        int needLength = oneWordLen * words.length;
        for (int i = 0; i < oneWordLen; i++) {
            int left = 0;
            int right = 0;
            int validCnt = 0;
            HashMap<String, Integer> windowMap = new HashMap<>();
            // 这个循环控制right边界
            while (i + right < s.length()) {
                if (i + right + oneWordLen > s.length()) break;
                String s1 = s.substring(i + right, i + right + oneWordLen);
                right += oneWordLen;
                if (needMap.containsKey(s1)) {
                    windowMap.put(s1, windowMap.getOrDefault(s1, 0) + 1);
                    if (windowMap.get(s1).equals(needMap.get(s1))) {
                        validCnt++;
                    }
                } else {
                    // 不包含 然后清空windowMap validCnt
                    left = right;
                    windowMap.clear();
                    validCnt = 0;
                }
//                System.out.printf("left: %d, right: %d, i: %d \n", left, right, i);
                if (right - left >= needLength) {
                    // 当前windowMap窗口和needMap 里面的key对应上，并且值相等
                    if (validCnt == needMap.size()) {
                        res.add(left + i);
                    }
                    String s2 = s.substring(i + left, i + left + oneWordLen);
                    left += oneWordLen;
                    if (needMap.containsKey(s2)) {
                        if (needMap.get(s2).equals(windowMap.get(s2))) {
                            validCnt--;
                        }
                        windowMap.put(s2, windowMap.get(s2) - 1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String s = "barfoothefoobarman";
//        String[] words = {"foo", "bar"};
//        String s = "barfoofoobarthefoobarman";
//        String[] words = {"bar", "foo", "the"};
//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"word", "good", "best", "good"};
        String s = "dddddddddddd";
        String[] words = {"dddd", "dddd"};

        List<Integer> list = findSubstring(s, words);
        System.out.println(list);
    }

}
