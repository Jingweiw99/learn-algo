package com.wjw;

import java.util.Arrays;

/*
拆炸弹问题
如果k>0这个位置上的数替换成后k个数的和
如果k<0这个位置上的数替换成前k个数的和
如果k=0这个位置上的数设置为0
 */
public class Lc1652 {
    public int[] decrypt(int[] code, int k) {
        // 枚举这个数组，每次设置上值
        // 考虑暴力做法 过程中k>0 k--每次加上对应的值
        int n = code.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (k < 0) {
                // i-1... i - k
                int m = k;
                for (int j = (i - 1 + n) % n; m < 0; j = (j - 1 + n) % n, m++) {
                    newArr[i] += code[j];
                }
            } else if (k > 0) {
                // j = i + 1 ... i + k
                int m = k;
                for (int j = (i + 1) % n; m > 0; j = (j + 1) % n, m--) {
                    newArr[i] += code[j];
                }
            }
        }
        return newArr;
    }


    public static void main(String[] args) {
        int[] code = {5, 7, 1, 4};
        Lc1652 test = new Lc1652();
        int[] newArr = test.decrypt(code, 3);
        System.out.println(Arrays.toString(newArr));
    }
}
