package com.wjw.backtrack;


import java.util.ArrayList;
import java.util.List;

public class Lc17_ {
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private final List<String> ans = new ArrayList<>();
    private char[] digits;
    private char[] path;

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return ans;
        }
        this.digits = digits.toCharArray();
        path = new char[n]; // 注意 path 长度一开始就是 n，不是空数组
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }
        for (char c : MAPPING[digits[i] - '0'].toCharArray()) {
            path[i] = c; // 直接覆盖
            dfs(i + 1);
        }
    }
    public static void main(String[] args) {
        Lc17_ test = new Lc17_();
        List<String> strings = test.letterCombinations("23");
        System.out.println(strings);
    }
}
