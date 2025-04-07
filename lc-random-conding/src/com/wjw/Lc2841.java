package com.wjw;

import java.util.*;
import java.util.logging.Handler;

/*
几乎唯一子数组的最大和
给一个nums 数组 一个m，一个k
在nums的长度为k的子数组中，  至少有m个不同的数字称之为几乎唯一子数组
 */
public class Lc2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        // 枚举这个数组定长为k|
        long max = 0;
        long sum = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            Integer curNum = nums.get(i);
            sum += curNum;
            if (!cnt.containsKey(curNum)) {
                cnt.put(curNum, 1);
            } else {
                cnt.put(curNum, cnt.get(curNum) + 1);
            }
            if (i < k - 1)
                continue;
            if (cnt.size() >= m) {
                max = Math.max(max, sum);
            }
            Integer removeNum = nums.get(i - k + 1);
            sum -= removeNum;
            if (cnt.get(removeNum) - 1 <= 0) {
                cnt.remove(removeNum);
            } else {
                cnt.put(removeNum, cnt.get(removeNum) - 1);
            }
        }
        return max;
    }
    // 这个方法可以判断是不是 唯一子数组  但是这题用不上
    private boolean isWy(List<Integer> nums, int end, int start, int m) {
        // 给nums的start - end遍历添加到map中，最后判断size>=m
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = start; i <= end; i++) {
            Integer num = nums.get(i);
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        return map.size() >= m;
    }

    public static void main(String[] args) {
        Lc2841 test = new Lc2841();
        long l = test.maxSum(Arrays.asList(2, 6, 7, 3, 1, 7), 3, 4);
        System.out.println(l); // 18
    }
}
