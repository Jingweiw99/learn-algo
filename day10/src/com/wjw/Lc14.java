package com.wjw;

/*
最长公共前缀

 */
public class Lc14 {
    public static String longestCommonPrefix(String[] strs) {
        // 如果只有一行直接返回
        // 大致思路就是固定j，对比当前行和上一行
        int cols = strs[0].length();
        for (int j = 0; j < cols; j++) {
            for (int i = 1; i < strs.length; i++) {
                // 对比这一行与上一行的字符，  !(j < Math.min(strs[i - 1].length(), strs[i].length()))  可以修改为 j>=任意一个
                if (!(j < Math.min(strs[i - 1].length(), strs[i].length())) || strs[i].charAt(j) != strs[i - 1].charAt(j)) {
                    return strs[0].substring(0, j);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"0"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
        System.out.println();
    }
}
