package com.wjw;

/*
删除有序链表中的所有重复元素， 一次都不保留
 */
public class Lc82 {
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy, q = head;
        while (q != null) {
            if (q.next != null && q.val == q.next.val) {
                while (q.next != null && q.val == q.next.val) {
                    q = q.next;
                }
                q = q.next;
                // 此时 q 跳过了这一段重复元素 比如 1 -> 2 -> 2这种情况 我们只添加了1到p后面，22 需要删除
                if (q == null) {
                    p.next = null;
                }
            } else {
                // 不是重复节点，接到 dummy 后面
                p.next = q;
                p = p.next;
                q = q.next;
            }
        }
        return dummy.next;
    }
}
