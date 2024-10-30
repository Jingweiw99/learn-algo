package com.wjw;

// 二分法
/*
一个有序数组，通过每次二分，是否能够找到对应的值
 */
/*
常数级别的操作  和数据量无关的操作
什么是时间复杂度？
·
 */
public class Dichotomy {
    public static boolean find(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int L = 0;
        int R = arr.length - 1;
        while (L <= R) {
//            int mid = (L + R) / 2;
            int mid = L + ((R - L) >> 1);
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }

    // 找出大于等于一个数的最左位置
    public static int findLeftIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (arr[mid] >= num) {
                ans = mid;
                R = R - 1;
            } else {
                L = L + 1;
            }
        }
        return ans;
    }

    // 找出小于等于一个数的最右位置
    public static int findRightIndex(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int L = 0;
        int R = arr.length - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            // 向右逼近的过程中才更新ans
            if (num >= arr[mid]) {
                ans = mid;
                L = L + 1;
            } else {
                R = R - 1;
            }
        }
        return ans;
    }
}
