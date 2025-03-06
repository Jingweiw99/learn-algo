package com.wjw.mianshi;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
会议室2 招商银行永隆 笔试题
给一个int[][] meetings判断一个人最多能参加多少次会议
其实这题是使用贪心算法，需要找出对应的贪心规律
排序策略有从开始时间排序，从最短的时间排序，从结尾时间排序
从结果上看只有从结束时间排序是对的。

如果当前开始大于等于当前结束时间可以安排会议 cnt++
如果当前开始小于当前结束时间会议继续走
 */
public class Solution7 {
    public int canJoinMeetings(int[][] meetings) {
        if (meetings == null || meetings.length == 0) return 0;
        // 结束时间进行排序
        int cnt = 1;
        Arrays.sort(meetings, (m1, m2) -> m1[1] - m2[1]);
        // 贪心，每次按照最短的结束时间来安排会议
        int end = meetings[0][1];
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] >= end) {
                cnt++;
                end = meetings[i][1];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution7 test = new Solution7();
        int[][] meetings = new int[][]{{1, 2}, {3, 4}, {4, 5}};
//        int[][] meetings = new int[][]{{1, 3}, {2, 4}, {4, 5}, {5, 7}, {3, 7}};
        System.out.println(test.canJoinMeetings(meetings)); // 3 3
    }

}
