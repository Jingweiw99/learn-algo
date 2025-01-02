package com.wjw.array;

import java.util.HashSet;
import java.util.Set;

/*
缺失的第一个正数
 */
public class Lc41 {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }

        for (int i = 1; i <= len ; i++) {
            if (!hashSet.contains(i)){
                return i;
            }
        }
        return len + 1;
    }

    public static void main(String[] args) {
        Lc41 test = new Lc41();
        System.out.println(test.firstMissingPositive(new int[]{7, 8, 9, 10, 11})); // 1
    }
}
