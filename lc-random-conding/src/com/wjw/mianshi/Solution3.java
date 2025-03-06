package com.wjw.mianshi;

import java.util.Arrays;
import java.util.Scanner;

/*
字符串的初始化
输入：
abc,DeF ghi JKL, oPq
输出:
abc,Def Ghi Jkl,Opq

 */
public class Solution3 {
    public String transStr(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 判断当前是, 空格
            if (chars[i] == ',' || chars[i] == ' ') {
                // 判断下一个字符是否是大写
                if (chars[i + 1] >= 97 && chars[i + 1] <= 122) { // 是小写的
                    // 否：这个位置转换成大写
                    chars[i + 1] = (char) (chars[i + 1] - 32);
                }
                i++;
            } else {
                // 判断是否是小写
                if (!(chars[i] >= 97 && chars[i] <= 122)) {
                    // 不是小写：转换成小写
                    chars[i] = (char) (chars[i] + 32);
                }
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Solution3 test = new Solution3();
        System.out.println(test.transStr(str));
    }
}
