package com.wjw.linkedList;

/*
两两交换链表中的节点
这里是迭代解法
核心思路：按组遍历，然后每次过程中需要上一次迭代的头结点，维护出来
 */
public class Lc24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode pGroup = head;
        ListNode preHead = dummy;
        while (pGroup != null && pGroup.next != null) {
            ListNode nextHead = pGroup.next.next;
            ListNode pGNext = pGroup.next;
            pGNext.next = pGroup;
            pGroup.next = nextHead;
            preHead.next = pGNext;

            preHead = pGroup;
            pGroup = nextHead;
        }
        return dummy.next;
    }
}
