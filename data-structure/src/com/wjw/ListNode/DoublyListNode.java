package com.wjw.ListNode;

// 双向链表，使用数组实现双向链表
public class DoublyListNode {
    int val;
    DoublyListNode next, pre;

    DoublyListNode(int val) {
        this.val = val;
    }

    public static DoublyListNode createDoublyListNode(int[] nums) {
        if (nums == null || nums.length < 1) return null;
        DoublyListNode dummy = new DoublyListNode(-1), p = dummy;
        for (int i = 0; i < nums.length; i++) {
            DoublyListNode node = new DoublyListNode(nums[i]);
            p.next = node;
            node.pre = p;
            p = p.next;
        }
        dummy.next.pre = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        DoublyListNode head = DoublyListNode.createDoublyListNode(new int[]{1, 2, 3});
        System.out.println(head);
    }
}
