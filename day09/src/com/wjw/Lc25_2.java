package com.wjw;

/*
反转k个一组链表
纯指针解法
 */
public class Lc25_2 {
    public static void main(String[] args) {
        Lc25_2 test = new Lc25_2();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode newHead = test.reverseKGroup(head, 2);
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
