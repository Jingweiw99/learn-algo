package com.wjw;

public class Lc21 {
    public static void main(String[] args) {
        String str = "abcd";
        String substring = str.substring(1, 2);
        System.out.println(substring);
    }
    private class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    // 不使用dummy节点，需要处理p p1 p2边界情况
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        // 如果不使用虚拟节点 比较麻烦需要处理 p1 p2 p null的情况
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode p1 = list1, p2 = list2;
        ListNode p = null;
        ListNode head = null;
        if (p == null && p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p = p1;
                p1 = p1.next;
            } else {
                p = p2;
                p2 = p2.next;
            }
            head = p;
        }
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return head;
    }

    /*
    使用dummy节点
    比较简便
    什么时候使用dummy节点？
    当我们需要创建一个新链表的时候，使用dummy节点简化情况。
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }
}
