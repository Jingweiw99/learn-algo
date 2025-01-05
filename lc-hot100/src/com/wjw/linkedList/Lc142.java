package com.wjw.linkedList;

import java.util.HashSet;
import java.util.Set;

/*
环形链表2: 返回入环的第一个节点，如果没有返回null
我直接使用的set方式  只在于空间上的区别
采用数学方案比较不好推导

核心思路： 和环形链表1一样，直接当包含的时候 返回的是当前节点，  在最后修改false为null
 */
public class Lc142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode p = head;
        while (p != null) {
            if (set.contains(p)) {
                return p;
            }
            set.add(p);
            p = p.next;
        }
        return null;
    }

}
