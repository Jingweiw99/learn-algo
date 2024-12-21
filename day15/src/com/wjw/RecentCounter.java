package com.wjw;

import java.util.LinkedList;
import java.util.Queue;

/*
最近请求次数
这里要求3000
 */
class RecentCounter {
    private Queue<Integer> q;

    public RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.offer(t);
        while (!q.isEmpty() && t - q.peek() > 3000) {
            q.poll();
        }
        return q.size();
    }
}
