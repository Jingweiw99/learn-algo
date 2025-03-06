package com.wjw;

import java.util.HashSet;

/*
环形链表：判断链表中是否有环
简单的不考虑空间复杂度的做法
遍历链表，每次遍历将值加入到set集合中，在这之前判断是否有了这个
有：return true
循环结束 return false
 */
public class Lc141 {
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) return true;
            set.add(cur);
            cur = cur.next;
        }
        return false;
    }

    /*
    优化空间复杂度
    fast每次走两步，slow每次走一步，如果快指针能够追上慢指针说明是环形链表
     */
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2, new ListNode(3, node4));
        node4.next = node2;
        ListNode head = new ListNode(1, node2);
        Lc141 test = new Lc141();
        System.out.println(test.hasCycle(head)); // true
    }
}