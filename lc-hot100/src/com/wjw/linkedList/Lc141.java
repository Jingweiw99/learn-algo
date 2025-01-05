package com.wjw.linkedList;

import java.util.HashSet;

/*
判断是否是环形链表
思路 fast 走两步， slow走一步，如果能追上就是环形链表，不能追上就不是
 */
public class Lc141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) // 唯一注意这个不要判断val，判断节点是否相等
                return true;
        }
        return false;
    }

    // 如果采用的是HashSet方式 核心思路是 一步一步的走，并收到set中，如果发现节点相同，那么就是环形链表，能走完就不是
    // 相较于上面的这个空间复杂度是(n)
    public boolean hasCycle2(ListNode head) {
        ListNode p = head;
        HashSet<ListNode> set = new HashSet<>();
        while (p != null) {
            if (set.contains(p)) {
                return true;
            }
            set.add(p);
            p = p.next;
        }
        return false;
    }
}
