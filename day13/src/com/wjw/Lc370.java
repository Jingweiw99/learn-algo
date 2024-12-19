package com.wjw;

public class Lc370 {
    public int[] getModifiedArray(int length, int[][] updates) {
        Difference diff = new Difference(new int[length]);
        for (int[] update : updates) {
            diff.increment(update[0], update[1], update[2]);
        }
        return diff.result();
    }
}
