package com.wjw.linked;

/*
删除链表的倒数第n个节点
 */
public class Lc19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null)
            return null;
        ListNode p1 = head, p2 = head; // p1用来找到倒数第n个节点
        while (n > 0) {
            p2 = p2.next;
            n--;
        }
        ListNode dummy = new ListNode(-1, head), p1Pre = dummy;
        while (p2 != null) {
            // 找到p1的前面节点
            p1Pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        p1Pre.next = p1.next;
        return dummy.next;
    }
}
