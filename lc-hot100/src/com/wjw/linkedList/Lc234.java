package com.wjw.linkedList;

/*
判断是否是回文链表

思路1： 直接反转链表，然后判断遍历的反过来链表的每个值和之前的原链表的值对比
思路2： 反向遍历链表 然后对比（如何反向，通过递归后序遍历）
思路3： 找到中间节点，然后反转right，然后对比
 */
public class Lc234 {
    // 思路2
    ListNode left;
    boolean isPan = true;

    public boolean isPalindrome(ListNode head) {
        left = head;
        traverse(head);
        return isPan;
    }

    private void traverse(ListNode right) {
        if (right == null) return;
        traverse(right.next);
        if (right.val != left.val) {
            isPan = false;
        }
        left = left.next;
    }

}
