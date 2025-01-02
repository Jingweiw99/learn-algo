package com.wjw.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/*
合并区间
基本思路就是 按照start 排序，如果前面一个的1位置上的值<=后一个位置上的0位置上的值，那么合并。
合并后的值我们先用LinkedList来收集，然后转换为二维数组。
 */
public class Lc56 {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> ll = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ll.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int[] pre = ll.getLast();
            if (cur[0] <= pre[1]) {
                pre[1] = Math.max(cur[1], pre[1]);
            } else {
                ll.add(cur);
            }
        }
        int[][] res = new int[ll.size()][2];
        int i = 0;
        for (int[] nums : ll) {
            res[i] = nums;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Lc56 test = new Lc56();
        int[][] intervals = new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}};
        int[][] arr = test.merge(intervals);
        for (int[] nums : arr) {
            System.out.println(Arrays.toString(nums));
        }
    }
}
