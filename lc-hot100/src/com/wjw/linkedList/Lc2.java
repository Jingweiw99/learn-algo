package com.wjw.linkedList;

/*
两数相加
 */
public class Lc2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1), p = dummy;
        int carry = 0;
        while (p1 != null && p2 != null) {
            int sum = p1.val + p2.val + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            p1 = p1.next;
            p2 = p2.next;
        }
        // 要么p1 为空， 要么p2 为空   如果p1为空，需要计算p2 反之计算p1
        if (p1 == null) {
            while (p2 != null) {
                int sum = p2.val + carry;
                carry = sum / 10;
                p.next = new ListNode(sum % 10);
                p = p.next;
                p2 = p2.next;
            }
        }
        if (p2 == null) {
            while (p1 != null) {
                int sum = p1.val + carry;
                carry = sum / 10;
                p.next = new ListNode(sum % 10);
                p = p.next;
                p1 = p1.next;
            }
        }
        if (carry > 0) p.next = new ListNode(carry);
        return dummy.next;
    }
}
