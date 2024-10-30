package com.wjw.linkedList;

// https://leetcode.com/problems/reverse-nodes-in-k-group/
public class ReverseNodeKGroup {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = findKEnd(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = findKEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    private void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    private ListNode findKEnd(ListNode start, int k) {
        // start为空是不够k个的情况，直接返回null
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }
}

/*
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode end = findKEnd(start, k);
        if (end == null) {
            return head;
        }
        head = end;
        reverse(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = findKEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }
        return head;
    }

    private void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }

    private ListNode findKEnd(ListNode start, int k) {
        // start为空是不够k个的情况，直接返回null
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }
}
 */
