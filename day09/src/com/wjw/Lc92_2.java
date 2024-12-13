package com.wjw;

/*
92题翻转链表区间的第二种解法

思路： 找到left前一个节点， 后面翻转right-left+1个节点，返回新的头节点。
前一个节点连接上
 */
public class Lc92_2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode newHead = reverseBetween(head, 2, 4);
    }
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head), p = dummy;
        // left 1 p去找到left-1索引的节点 需要走left-1
        for(int i = 1; i < left; i++) {
            p = p.next;
        }
        ListNode preNode = p;
        ListNode nextNode = reverseN(p.next, right - left + 1);
        preNode.next = nextNode;
        return dummy.next;
    }
    private static ListNode reverseN(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
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
