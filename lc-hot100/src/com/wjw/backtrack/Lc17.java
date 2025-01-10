package com.wjw.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
电话号码的字母组合
 */
public class Lc17 {
    String[] maps = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return res;
        backtrack(digits, 0);
        return res;
    }

    private void backtrack(String digits, int start) {
        if (digits.length() == start) {
            res.add(sb.toString());
            return;
        }
        int num = digits.charAt(start) - '0';
        for (char c : maps[num].toCharArray()) {
            sb.append(c);
            backtrack(digits, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Lc17 test = new Lc17();
        List<String> strings = test.letterCombinations("23");
        System.out.println(strings);
    }
}
