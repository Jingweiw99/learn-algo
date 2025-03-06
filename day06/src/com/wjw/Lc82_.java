package com.wjw;

/*
删除有序链表中的所有重复元素， 一次都不保留
 */
public class Lc82_ {
    private static class ListNode {
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
        // 给一个dummy虚拟节点
        ListNode dummy = new ListNode(-1), p1 = dummy;
        // 遍历head节点，如果当前p节点与后面一个节点的值不相等 dummy就添加上当前节点
        ListNode p = head;
        while (p != null) {
            if (p.next == null) {
                p1.next = p;
                break;
            }
            if (p.val != p.next.val) {
                p1.next = p;
                p1 = p1.next;
                p = p.next;
            } else {
                // 否则让p指针指向不等于当前值的节点
                int curVal = p.val;
                while (p.val == curVal) {
                    p = p.next;
                }
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Lc82_ test = new Lc82_();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(4)))));
//                ListNode head = new ListNode(1, new ListNode(2, new ListNode(2)));
        ListNode newNode = test.deleteDuplicates(head);
        System.out.println(newNode);
    }
}
