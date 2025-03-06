package com.wjw;

/*
合并两个链表
先给一个dummy节点 -1 遍历 l1 l2 添加上去
判断l1 是否还有 l2是否还有 添加上
最后返回dummy.next;
 */
public class Lc21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
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

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        Lc21 test = new Lc21();
        ListNode mergedList = test.mergeTwoLists(list1, list2);
        System.out.println(mergedList); // 112344
    }
}
