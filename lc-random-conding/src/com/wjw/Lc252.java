package com.wjw;

import java.util.Arrays;

/*
会议室问题
 */
public class Lc252 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);
        for (int i = 1; i < intervals.length; i++) {
            // 当前开始与前面的最大值相比，如果小于return false
            if (intervals[i][0] < intervals[i - 1][1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Lc252 test = new Lc252();
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}};
        System.out.println(test.canAttendMeetings(intervals));
    }
}
