package com.wjw.linkedList;

import java.util.PriorityQueue;

/*
合并k个有序链表
 */
public class Lc23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode dummy = new ListNode(-1), p = dummy;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            p.next = cur;
            p = p.next;
            cur = cur.next;
            if(cur != null) pq.offer(cur);
        }
        return dummy.next;
    }
}
