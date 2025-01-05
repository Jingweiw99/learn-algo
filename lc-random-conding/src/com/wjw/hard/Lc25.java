package com.wjw.hard;

/*
这题多种解法
最简单直接写出来的是这种 迭代解法
k个一组反转链表
 */
public class Lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode gHead = head;
        ListNode preGHead = dummy;
        while (gHead != null) {
            ListNode gEnd = findEnd(gHead, k);
            // 找到k个节点然后如果不足k个，不需要反转了，直接结束
            if (gEnd == null) {
                return dummy.next;
            }
            ListNode gEndNext = gEnd.next;
            reverse(gHead, gEnd);
            preGHead.next = gEnd;

            preGHead = gHead;
            gHead = gEndNext;
        }
        return dummy.next;
    }

    // 反转head -> end 然后head指向end的下一个节点 这里保证了head end不为null
    private void reverse(ListNode head, ListNode end) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != end) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        head.next = end.next;
        end.next = pre;
    }

    // 找到head的第k个节点，如果不足k个返回null
    private ListNode findEnd(ListNode head, int k) {
        ListNode p = head;
        for (int i = 1; i <= k - 1 && p != null; i++) {
            p = p.next;
        }
        return p;
    }
}
