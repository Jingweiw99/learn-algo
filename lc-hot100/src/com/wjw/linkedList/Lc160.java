package com.wjw.linkedList;

import java.util.HashSet;

/*
返回链表的相交链表
返回相交节点，否则返回null
 */
public class Lc160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode p1 = headA;
        while (p1 != null) {
            set.add(p1);
            p1 = p1.next;
        }
        ListNode p2 = headB;
        while (p2 != null) {
            if (set.contains(p2)) {
                return p2;
            }
            p2 = p2.next;
        }
        return null;
    }
}
