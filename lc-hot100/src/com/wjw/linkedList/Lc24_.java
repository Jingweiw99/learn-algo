package com.wjw.linkedList;

/*
两两交换链表中的节点
递归解法
这里函数定义是 给一个head，两两交换，然后返回新头节点
 */
public class Lc24_ {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
