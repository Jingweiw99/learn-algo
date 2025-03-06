package com.wjw;

public class Lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode groupHead = head;
        ListNode preGroupHead = dummy;
        while (groupHead != null) {
            ListNode groupEnd = findKNode(groupHead, k);
            if (groupEnd == null) {
                return dummy.next;
            }
            ListNode groupEndNxt = groupEnd.next;
            reverse(groupHead, groupEnd);
            preGroupHead.next = groupEnd;
            preGroupHead = groupHead;
            groupHead = groupEndNxt;
        }
        return dummy.next;
    }

    // 翻转head - end的节点 保证了end不为空了 并将head.next指 end原来的next
    private void reverse(ListNode head, ListNode end) {
        ListNode pre = end.next, cur = head;
        while (cur != end) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        end.next = pre;
    }

    // head开始找第k个节点 k<=n k = 1, 2... 如果超过了就返回null
    private ListNode findKNode(ListNode head, int k) {
        ListNode p = head;
        while (k > 1 && p != null) {
            p = p.next;
            k--;
        }
        return p;
    }

    public static void main(String[] args) {
        Lc25 test = new Lc25();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode node = test.reverseKGroup(head, 2);
        System.out.println(node);
    }
}
