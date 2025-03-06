package com.wjw.mianshi;

import java.util.Locale;

/*
输入一串英文对话，请你输出翻转每个单词后的句子
输入：ohW era uoy? I ma xelA.
输出：Who are you? I am Alex.
 */
public class Solution1 {
    public String reverseAtr(String article) {
        StringBuilder sb = new StringBuilder();
        // 1. 先切割成数组
        String[] s = article.split(" ");
        // 2. 数组里面翻转
        int i = 1;
        for (String s1 : s) {
            char[] chars = s1.toCharArray();
            reverseStr(chars);
            if (i == s.length) {
                sb.append(String.valueOf(chars));
                break;
            }
            sb.append(String.valueOf(chars) + " ");
            i++;
        }
        // 3. 翻转之后再给为字符串
        return sb.toString();
    }

    // 翻转str，如果是,.?特殊处理
    private void reverseStr(char[] chars) {
        char ch = chars[chars.length - 1];
        // 如果是普通情况直接翻转，如果是特殊的以这些结尾的需要翻转的是 0-len-2
        int left = 0, right = chars.length - 1;

        if (ch == ',' || ch == '.' || ch == '?') {
            right = chars.length - 2;
        }
        // 对chars翻转
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }


    public String reverseAtr2(String article) {
        String[] strArr = article.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            // 如果是以符号结尾翻转 0-n-2 否则翻转0-n-1
            int n = str.length();
            char endCh = str.charAt(n - 1);
            int left = 0, right = n - 1;
            StringBuilder sb1;
            if (endCh == ',' || endCh == '.' || endCh == '?') {
                sb1 = new StringBuilder(str.substring(left, right)).reverse().append(endCh + " ");
            } else {
                sb1 = new StringBuilder(str.substring(left, right + 1)).reverse().append(" ");
            }
            sb.append(sb1);
        }
        return sb.substring(0, sb.length() - 1);
    }

    public void test() {
        System.out.println("测试中~");
    }
    public static void main(String[] args) {
        Solution1 test = new Solution1();
        System.out.println(test.reverseAtr2("ohW era uoy? I ma xelA."));
    }
}
