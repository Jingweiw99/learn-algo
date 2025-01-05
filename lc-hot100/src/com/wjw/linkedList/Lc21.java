package com.wjw.linkedList;

/*
合并两个升序的单链表
 */
public class Lc21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2;
        ListNode dummy = new ListNode(-1, null), p = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        // 如果p1为null需要拼接p2  如果p2为空需要拼接p1
        if (p1 == null) {
            while (p2 != null) {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            }
        }
        if (p2 == null) {
            while (p1 != null) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
