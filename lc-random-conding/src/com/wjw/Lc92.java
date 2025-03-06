package com.wjw;

/*
lc 92 反转链表2
找到start前面一个节点，start节点， end节点 end的下一个节点

 */
public class Lc92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1, head);
        // lastLeftNode leftNode rightNode
        ListNode lastLeftNode = findNNode(dummy, left - 1);
        ListNode leftNode = lastLeftNode.next;
        ListNode rightNode = findNNode(dummy, right);
        ListNode nextRightNode = rightNode.next;
        // 反转 left - right 的链表
        reverse(leftNode, rightNode);
        // 反转之后
        lastLeftNode.next = rightNode;
        leftNode.next = nextRightNode;
        return dummy.next;
    }

    private void reverse(ListNode left, ListNode right) {
        ListNode pre = null, cur = left;
        while (cur != right) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        cur.next = pre;
    }

    // 找到head 索引i节点
    private ListNode findNNode(ListNode head, int i) {
        ListNode cur = head;
        while (i >= 1 && cur != null) {
            cur = cur.next;
            i--;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Lc92 test = new Lc92();
        ListNode reversedListNode = test.reverseBetween(head, 2, 4);
        System.out.println(reversedListNode);
    }
}