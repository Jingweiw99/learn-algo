package com.wjw;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
二叉堆： 一种可以动态排序的数据结构
能够动态排序的数据结构一个是二叉堆，   实现 优先级队列， 能动态排序的数据结构还有二叉搜索树，相较于优先级队列复杂。虽然二叉搜索树能做优先级队列的所有事情，但是优先级队列实现代码比较容易。  可以使用优先级队列，没有必要使用到二叉搜索树。

大堆顶，和小堆顶
最大元素是根节点， 最小元素是根节点。

左右子树也是二叉堆

二叉堆在pop和push的情况下会自动调整内部的排列

常用的四个api
add poll peek size

底层实现是二叉树，与队列无关， 但是性质形似与队列
 */
public class Erchadui {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
//       Comparator cmp = new Comparator<Integer>() {
//           @Override
//           public int compare(Integer o1, Integer o2) {
//               return o2 - o1;
//           }
//       };
//        heapSort(arr, cmp);
        heapSort(arr, (a, b) -> b - a);
        System.out.println(Arrays.toString(arr));
    }

    // 堆排序： 将数组的数据都add到堆里面去，然后poll出来收集
    public static void heapSort(int[] arr, Comparator<Integer> cmp) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(cmp);
        for (int num : arr) {
            pq.add(num);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = pq.poll();
        }
    }

    public static void apiTest() {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(2);
        q.add(1);
        System.out.println(q.peek());
        System.out.println(q.poll()); // 1 默认是小堆顶
    }

}
