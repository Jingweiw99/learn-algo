package com.wjw;

/*
反转k个一组链表 hard

递归基本思想：将大问题，分解成结构一致，规模更小的问题。
比如这题，传入头结点和翻转的个数k，返回k个一组返回的链表头结点
 */
public class Lc25 {
    public static void main(String[] args) {
        Lc25 test = new Lc25();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode newHead = test.reverseKGroup(head, 2);
    }

    public ListNode reverseKGroup(ListNode head, int k) {
//        if(head == null) return null;
        ListNode a = head, b = head;

        for (int i = 0; i < k; i++) {
            if (b == null) return head;
            b = b.next;
        }
        ListNode newHead = reverseN(a, k);
        a.next = reverseKGroup(b, k); // b 新的头结点第k+1个节点 a:reverseN之后的尾节点
        return newHead;
    }

    private ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null) return head;
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
