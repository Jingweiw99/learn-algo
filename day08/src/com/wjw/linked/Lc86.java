package com.wjw.linked;

/*
分割两个链表

这里需要注意的是，不是新创建节点添加，而是源节点拼接的时候，如果不断开原链接，会出现环状结构。
 */
public class Lc86 {
     class ListNode {
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
    public ListNode partition(ListNode head, int x) {
        ListNode p = head;
        ListNode dummy1 = new ListNode(-1), dummy2 = new ListNode(-1);
        ListNode p1 = dummy1, p2 = dummy2;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            // p = p.next; 这里p不能直接前进
            ListNode temp  = p.next;
            p.next = null;
            p = temp;

        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
