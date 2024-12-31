package com.wjw;

import java.util.List;

/*
单词拆分
dp[i]定义为，s前i个字符串[0,i-1] 能否被分割成wordDict中的单词
dp[0] = true;
举个例子
s = "leetcode" wordDict = ["code", "leet"]
dp[4] = dp[0] && check([0~4))
dp[8] = dp[4] && check([4,8)) 这里8 是i，4是j
...

check用 wordDict 里面是否包含了 s.substring()  i-
 */
public class Lc139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
