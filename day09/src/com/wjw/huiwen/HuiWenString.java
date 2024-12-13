package com.wjw.huiwen;

public class HuiWenString {
    public static void main(String[] args) {
        HuiWenString test = new HuiWenString();
        System.out.println(test.isPan("abc"));
        System.out.println(test.isPan("abba"));

        System.out.println(test.finLongestPanStr("cabab", 2, 2));
        System.out.println(test.finLongestPanStr("caaab", 2, 3));
    }

    // 1. 判断一个字符串是不是回文字符串
    boolean isPan(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 找到以left right 为中心的最长回文串 一般来说相邻，或者相等，我们才找
    String finLongestPanStr(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }
}
