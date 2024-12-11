package com.wjw.linked;

import java.util.HashSet;

/*
相交链表

这里采用的是hashset解法
 */
public class Lc160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null) {
            set.add(p1);
            p1 = p1.next;
        }
        while (p2 != null) {
            if (set.contains(p2)) {
                return p2;
            }
            p2 = p2.next;
        }
        return null;
    }
}
