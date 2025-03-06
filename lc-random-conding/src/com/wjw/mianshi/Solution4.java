package com.wjw.mianshi;

import java.util.Scanner;

/*
字符串的最大回文前缀的长度
asdfdsa  7
1010  3
 */
public class Solution4 {
    /*
    给后一个指针遍历 p = (n-1  ~ 0)
    判断当前是否是回文串
        如果是 返回长度
        如果不是继续
     */
    public int longestPrefixLen(String str) {
        int p = str.length() - 1;
        while (p >= 0) {
            String str1 = str.substring(0, p + 1);
            if (isPan(str1)) {
                return p + 1;
            }
            p--;
        }
        return 1;
    }

    /*
    判断str是否是一个字符串
     */
    private boolean isPan(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution4 test = new Solution4();
        System.out.println(test.longestPrefixLen(str));
    }
}
