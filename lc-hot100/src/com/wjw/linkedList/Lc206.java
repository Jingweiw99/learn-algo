package com.wjw.linkedList;

/*
反转链表
返回反转后的头结点

我这样写是最少的一个代码
也可以将nxt抽取出来，但是代码量会多点。
 */
public class Lc206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, cur = head, nxt = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) nxt = nxt.next;
        }
        return pre;
    }

}
