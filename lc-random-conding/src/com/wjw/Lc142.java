package com.wjw;

import java.util.HashSet;

/*
环形链表2
找到入环的第一个节点，如果找不到返回null
方法一：核心思路set保存全部节点，是环形链表则可以找到相等的节点并返回；不是环形链表则遍历处理返回null
 */
public class Lc142 {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            // 判断是否包含  不包含：添加过去 包含了：直接返回这个节点
            if (set.contains(cur)) return cur;
            set.add(cur);
            cur = cur.next;
        }
        return null;
    }

    /*
        我这就使用方法一既可
        这里需要推导， 这个方法是不正确的
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return fast;
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node2 = new ListNode(2, new ListNode(3, node4));
        node4.next = node2;
        ListNode head = new ListNode(1, node2);
        Lc142 test = new Lc142();
        ListNode node = test.detectCycle(head);
        System.out.println(node); // 值为2的那个节点
    }
}
