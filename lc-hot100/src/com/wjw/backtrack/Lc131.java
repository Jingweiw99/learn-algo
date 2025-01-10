package com.wjw.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
分割回文串
输入的视角
 */
public class Lc131 {
    private List<List<String>> res = new ArrayList<>();
    private List<String> track = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, 0);
        return res;
    }

    // start当前回文子串的开始位置
    private void backtrack(String s, int i, int start) {
        if (i == s.length()) {
            res.add(new ArrayList<>(track));
            return;
        }
        // 对于最后一个一定要选
        if (i < s.length() - 1) {
            backtrack(s, i + 1, start);
        }

        if (isPalindrome(s, start, i)) {
            track.add(s.substring(start, i + 1));
            backtrack(s, i + 1, i + 1);
            track.remove(track.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        Lc131 test = new Lc131();
        System.out.println(test.partition(s));
    }
}
