package com.wjw.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
单词拆分
 */
public class Lc139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        // i是枚举的右边界 j是左边界
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j,i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Lc139 test = new Lc139();
        ArrayList<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(test.wordBreak("leetcode", list));
    }
}
