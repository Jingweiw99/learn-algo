package com.wjw;

/*
https://leetcode.cn/problems/reverse-linked-list-ii/
反转链表2
 */
public class Lc92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // 先找到leftLastNode leftNode rightNode rightNextNode
        ListNode leftLastNode = findNode(head, left - 1);
        ListNode leftNode = findNode(head, left);
        ListNode rightNode = findNode(head, right);
        ListNode rightNextNode = findNode(head, right + 1);
        if (leftLastNode == null) {
            head = rightNode;
        } else {
            leftLastNode.next = rightNode;
        }
        reverse(leftNode, rightNode);
        leftNode.next = rightNextNode;
        return head;
    }

    // 找到第k个位置上的节点 k= 1, 2, 3, ...
    private ListNode findNode(ListNode head, int k) {
        while (head != null) {
            k--;
            if (k == 0) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    // left right 反转
    private void reverse(ListNode leftNode, ListNode rightNode) {
        ListNode last = null;
        while (leftNode != rightNode) {
            ListNode temp = leftNode.next;
            leftNode.next = last;
            last = leftNode;
            leftNode = temp;
        }
        rightNode.next = last;
    }
}
