package com.wjw;

import java.util.HashSet;
import java.util.Set;

/*
    环形链表1
 */
public class Lc141 {
    /**
     * 如果使用传统的空间复杂度为n的解法
     * 总体思路给一个map收集全部的链表值，然后判断是否有环
     * 1. 初始化一个map
     * 2. 遍历链表添加到map中（添加的是节点，不是值，节点是引用地址，因此出现了重复数字也是可以的）
     * 3. 添加之前判断是否有 有返回true
     * 4. 遍历结束还没有，返回false
     */
    public boolean hasCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 考虑空间复杂的做法，使用快慢指针
     * 总体思路：  如果是环形链表快指针一定能追上慢指针
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    // 上述优化空间
    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            head = head.next;
            if (fast == head)
                return true;
        }
        return false;
    }
}
