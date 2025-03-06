package com.wjw.mianshi;

/*
输入两个数逆置后求和
 */
public class Solution2 {
    public int reverseAdd(int num1, int num2) {
        // 翻转num1 num2
        num1 = reverseNum(num1);
        num2 = reverseNum(num2);
        // 返回求和
        return num1 + num2;
    }

    private int reverseNum(int num) {
        int revNum = 0;
        int n1 = num;
        while (n1 != 0) {
            revNum = revNum * 10 + (n1 % 10);
            n1 = n1 / 10;
        }
        return revNum;
    }

    public static void main(String[] args) {
        Solution2 test = new Solution2();
        System.out.println(test.reverseAdd(123, 456));
        System.out.println(321 + 654);
    }
}
