package com.wjw;

/*
反转单链表
 */
public class ReverseNode {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode newHead = reverseNode2(head);
        System.out.println(newHead);
    }

    static ListNode reverseNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null, cur = head, nxt = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }
        return pre;
    }
    // 递归解法
    static ListNode reverseNode2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode last = reverseNode2(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
