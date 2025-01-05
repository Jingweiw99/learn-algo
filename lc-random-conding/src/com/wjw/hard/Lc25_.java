package com.wjw.hard;

/*
这题多种解法
这里是递归，需要结合反转前k个头结点
k个一组反转链表
 */
public class Lc25_ {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b == null)
                return head;
            b = b.next;
        }
        ListNode newHead = reverseN(a, k);
        a.next = reverseKGroup(b, k); // b 新的头结点第k+1个节点 a:reverseN之后的尾节点
        return newHead;
    }

    private ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null, cur = head, nxt = head.next;
        while (n > 0) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
            n--;
        }
        head.next = cur;
        return pre;
    }
}
