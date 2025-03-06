package com.wjw.mianshi;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
会议室2
给一个int[][] meetings判断最少需要多少间会议室
最小堆 每次是结束时间，与当前的开始时间对比
如果当前开始时间大于等于前面的结束时间弹出前面的，添加上这个的结束时间
否则offer进当前的结束值
最后最小堆的大小就是我们需要的会议室
 */
public class Solution6 {
    public int needMeetingRooms(int[][] meetings) {
        if (meetings == null || meetings.length == 0) return 0;
        // 先堆开始时间进行排序
        Arrays.sort(meetings, (m1, m2) -> m1[0] - m2[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(meetings[0][1]);
        for (int i = 1; i < meetings.length; i++) {
            if (!pq.isEmpty() && meetings[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(meetings[i][1]);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Solution6 test = new Solution6();
        int[][] meetings = new int[][]{{1, 2}, {3, 4}, {4, 5}};
//        int[][] meetings = new int[][]{{1, 3}, {2, 4}, {4, 5}};
        System.out.println(test.needMeetingRooms(meetings)); // 1 2
    }

}
