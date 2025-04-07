package com.wjw;

/*
字符串中定长字串的最多的元音数 a, e, i, o, u
 */
public class Lc1456 {
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int maxWord = 0;
        int valid = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                valid++;
            }
            if (i < k - 1)
                continue;
            maxWord = Math.max(maxWord, valid);
            char ch = chars[i - k + 1];
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                valid--;
            }
        }
        return maxWord;
    }

    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        Lc1456 test = new Lc1456();
        System.out.println(test.maxVowels(s, k)); // 3
    }
}
