package com.wjw.linkedList;

/*
判断是否是回文链表
使用中间节点来判断

中间 如果是奇数 fast直接找到末尾， slow找到中间元素
     如果是偶数  fast找到null   slow是中间靠后的一个元素
 */
public class Lc234_ {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) slow = slow.next;
        ListNode right = reverse(slow);
        ListNode left = head;
        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        return pre;
    }
}
