package com.wjw.linked;

import java.util.HashMap;

/*
从未排序的链表中删除重复元素  全部重复元素都需要删除掉。


 */
public class Lc1836 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(4, null)))))));
        ListNode newHead = deleteDuplicatesUnsorted(head);
        System.out.println(newHead);
    }

    static ListNode deleteDuplicatesUnsorted(ListNode head) {
        // 遍历一次存放节点的值，次数对应的映射  判断是否需要放入
        ListNode p = head;
        HashMap<Integer, Integer> count = new HashMap<>();
        while (p != null) {
            count.put(p.val, count.getOrDefault(p.val, 0) + 1);
            p = p.next;
        }
        ListNode dummy = new ListNode(-1, head);
        p = dummy;
        // 遍历二次 存放到节点中
        while (p != null) {
            ListNode unique = p.next;
            while (unique != null && count.get(unique.val) > 1) {
                unique = unique.next;
            }
            p.next = unique;
            p = p.next;
        }
        return dummy.next;
    }
}
