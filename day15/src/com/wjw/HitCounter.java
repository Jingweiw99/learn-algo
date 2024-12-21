package com.wjw;

import java.util.LinkedList;
import java.util.Queue;

/*
敲击计数器 Lc362
 */
public class HitCounter {
    Queue<Integer> q = new LinkedList<>();

    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    public int getHits(int timestamp) {
        // 保留队列中最近300秒的数据既可，其他全部弹出
        while (!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        return q.size();
    }
}
