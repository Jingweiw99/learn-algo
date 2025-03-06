package com.wjw;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution1 {
    public int attendmeetings(ArrayList<ArrayList<Integer>> meetings) {
        int cnt = 0; // 结果 最多可以参加多少次会议
        // 首先对会议进行排序
//        meetings = (ArrayList<ArrayList<Integer>>) meetings.stream().sorted((o1, o2) -> {
//            return o1.get(0) - o2.get(0);
//        }).collect(Collectors.toList());
        // 把一个meetings排序，不使用Collectors
        for (int i = 0; i < meetings.size(); i++) {
            // 冒泡排序
            for (int j = i; j < meetings.size() - 1; j++) {
                if (meetings.get(i).get(0) > meetings.get(i + 1).get(0)) {
                    // 交换
                    ArrayList<Integer> temp = meetings.get(i + 1);
                    meetings.set(i + 1, meetings.get(i));
                    meetings.set(i, temp);
                }
            }
        }
        int begin = meetings.get(0).get(0);
        int end = meetings.get(meetings.size() - 1).get(1);
        // 排序之后用最小值和最大值遍历
        while (begin <= end) {
            for (ArrayList<Integer> meeting : meetings) {
                // 判断是否包含了begin
                if (meeting.contains(begin)) {
                    // 包含了删除这项 结束
                    cnt++;
                    meetings.remove(meeting);
                    break;
                }
                // 没有包含继续走
            }
            begin++;
        }
        // 遇到一个选择当天天数
        return cnt;
    }

    public static void main(String[] args) {
        Solution1 test = new Solution1();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        list.add(a);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(2);
        c.add(3);
        list.add(c);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(3);
        list.add(b);
//
        System.out.println(test.attendmeetings(list));

    }
}
