package com.wjw.mianshi;

import java.util.Arrays;

/*
会议室1
给一个int[][] meetings判断是否能参加全部的会议
思路：
会议从小到大排序一下 开始时间
遍历meetings，1-n-1
每个meeting 判断这个开始时间是否大于前面的结束时间
是：继续
否：返回false
 */
public class Solution5 {
    public boolean canJoinAllMeeting(int[][] meetings) {
        if (meetings == null || meetings.length == 0) return true;
        Arrays.sort(meetings, (m1, m2) -> m1[0] - m2[0]);
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] < meetings[i - 1][1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution5 test = new Solution5();
//        int[][] meetings = new int[][]{{1, 2}, {3, 4}, {4, 5}};
        int[][] meetings = new int[][]{{1, 3}, {2, 4}, {4, 5}};
        System.out.println(test.canJoinAllMeeting(meetings));
    }

}
