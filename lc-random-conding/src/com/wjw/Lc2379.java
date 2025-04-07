package com.wjw;

/*
涂到k个黑快的最少涂色次数
 */
public class Lc2379 {
    public int minimumRecolors(String blocks, int k) {
        // 可以转换成找到k个瓷砖中 最多的黑色数量 ，最后返回 k- maxBlack
        int maxBlack = 0;
        int cnt = 0; // 黑瓷砖的次数
        char[] chars = blocks.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == 'B') {
                cnt++;
            }
            if(i < k - 1)
                continue;
            maxBlack = Math.max(maxBlack, cnt);
            if(chars[i - k + 1] == 'B') {
                cnt--;
            }
        }
        return k - maxBlack;
    }
    public int minimumRecolors2(String blocks, int k) {
        // 可以转换成找到k个瓷砖中 最多的黑色数量 ，最后返回 k- maxBlack
        int maxBlack = 0;
        int cnt = 0; // 黑瓷砖的次数
        char[] chars = blocks.toCharArray();
        for (int i = 0; i < k; i++) {
            if(chars[i] == 'B') {
                cnt++;
            }
        }
        maxBlack = Math.max(maxBlack, cnt);
        for (int i = k; i < chars.length; i++) {
            if(chars[i] == 'B') {
                cnt++;
            }
            maxBlack = Math.max(maxBlack, cnt);
            if(chars[i - k + 1] == 'B') {
                cnt--;
            }
        }
        return k - maxBlack;
    }
}
