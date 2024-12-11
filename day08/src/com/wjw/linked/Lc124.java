package com.wjw.linked;

import java.util.HashSet;
import java.util.Set;

/*
环形链表2
找到是不是环形链表，如果是直接返回那个环节点，如果不是返回null

这里采用最简单的hashset解法
 */
public class Lc124 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p  = head;
        while(p != null) {
            if(set.contains(p)) {
                return p;
            }
            set.add(p);
            p = p.next;
        }
        return null;
    }
}
