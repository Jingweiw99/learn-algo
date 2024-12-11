package com.wjw.linked;


/*
合并两个有序链表
什么时候创建dummy节点，需要创建一个新节点的时候，使用虚拟头结点简化边界情况。
 */
public class Lc21 {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //
        ListNode p1 = list1, p2 = list2;
        ListNode dummy = new ListNode(-1), p = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        // 简化成这个不需要while循环的过程
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }
}
