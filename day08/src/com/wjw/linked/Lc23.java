package com.wjw.linked;

import java.util.PriorityQueue;

public class Lc23 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        ListNode dummy = new ListNode(-1), p = dummy;
        for (ListNode list : lists) {
            pq.offer(list);
        }

        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            p.next = minNode;
            p = p.next;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Lc23 test = new Lc23();
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));
        ListNode head = test.mergeKLists(lists);
        System.out.println(head);
    }
}
