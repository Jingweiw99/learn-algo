package com.wjw;

/*
大小为k的子数组的平均值大于等于阈值的个数
 */
public class Lc1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int valid = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i < k - 1)
                continue;
            if (sum >= k * threshold)
                valid++;
            sum -= arr[i - k + 1];
        }
        return valid;
    }
}
