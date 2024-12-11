package com.wjw.linked;

/*
删除有序链表中的重复元素2
删除全部  1->2->2->3->4  =>  1->3->4
 */
public class Lc82 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(4, null)))))));
        ListNode newHead = deleteDuplicates(head);
        System.out.println(newHead);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode p1 = head;
        ListNode dummy = new ListNode(-1), p = dummy;
        while (p1 != null) {
            // 下一个不为空，并且等于下一个
            if (p1.next != null && p1.val == p1.next.val) {
                // 跳过重复节点
                while (p1.next != null && p1.val == p1.next.val) {
                    p1 = p1.next;
                }
                p1 = p1.next;
                if (p1 == null) {
                    // 走到空了
                    p.next = null;
                }
            } else {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            }
        }
        return dummy.next;
    }
}
