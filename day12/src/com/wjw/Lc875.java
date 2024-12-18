package com.wjw;

/*
在H小时之内，吃完piles 香蕉（i堆香蕉每堆是piles[i]）， 求最小速度k
 */
public class Lc875 {
    static int minEatingSpeed(int[] piles, int H) {
        // 吃香蕉的速度 和吃完的时间成反比
        int left = 1, right = 1000000000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midEatTime = eatTime(piles, mid);
            if (midEatTime > H) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    static int eatTime(int[] piles, int k) {
        int sum = 0;
        for (int pile : piles) {
            sum += pile % k != 0 ? pile / k + 1 : pile / k;
        }
        return sum;
    }

    public static void main(String[] args) {
        int i = minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
        System.out.println(i);
    }
}
