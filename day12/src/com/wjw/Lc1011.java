package com.wjw;

/*
货物装载问题
 */
public class Lc1011 {
    public static int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 1;
        for (int weight : weights) {
            left = Math.max(left, weight); // 每次最少都需要装一件货物走，这个要加上
            right += weight;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midVal = getDay(weights, mid);
            if (midVal <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 装载货物cap位k的时候，需要多少天
    private static int getDay(int[] weights, int cap) {
        int days = 0;
        int i = 0;
        while (i < weights.length) {
            int cap1 = cap;
            while (i < weights.length && cap1 > 0) {
                if (cap1 - weights[i] < 0) break;
                cap1 -= weights[i];
                i++;
            }
            days++;
        }
        return days;
    }

    public static void main(String[] args) {
        int cap = shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5);
        System.out.println(cap);

//        System.out.println(getDay(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 15));
    }
}
