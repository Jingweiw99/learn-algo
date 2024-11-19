package com.wjw;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class StackQueueIntroduce {
    /*
    Java中栈和队列
    Stack 栈
    Queue 队列
    Deque 双端队列 可以用LinkedList实现 Deque<String> deque = new LinkedList<>();
    PriorityQueue 优先级队列
     */
//    Stack

    /*
    Deque api
    addFirst 双端队列的开头添加指定的元素
    addLast
    offerFirst 素昂端队列的开头添加指定的元素，与上述不同的是，队列满了，返回false
    offerLast
    getFirst
    getLast
    peekFirst
    peekLast
    removeFirst
    removeLast
    pollFirst
    pollLast

    offer peek poll 都是如果出现问题，返回false或者null，而不是直接抛出异常
     */
    public static void main1(String[] args) {
        // 使用ArrayDeque或者LinkedList创建Deque
//        Deque<Integer> numbers = new ArrayDeque<>();
        Deque<Integer> numbers = new LinkedList<>();

        //添加元素到Deque
        numbers.offer(1);
        numbers.offerLast(2);
        numbers.offerFirst(3);
        System.out.println("Deque: " + numbers);

        //访问Deque的元素
        int firstElement = numbers.peekFirst();
        System.out.println("第一个元素： " + firstElement);

        int lastElement = numbers.peekLast();
        System.out.println("最后一个元素： " + lastElement);

        //从Deque 移除元素
        int removedNumber1 = numbers.pollFirst();
        System.out.println("移除第一个元素： " + removedNumber1);

        int removedNumber2 = numbers.pollLast();
        System.out.println("移除最后一个元素： " + removedNumber2);

        System.out.println("更新后的Deque： " + numbers);
    }

    public static void main(String[] args) {
        //创建优先队列 优先队列的头是最小的元素
        PriorityQueue<Integer> numbers = new PriorityQueue<>();

        //使用add()方法
        numbers.add(4);
        numbers.add(2);
        System.out.println("PriorityQueue: " + numbers);

        //使用offer()方法 如果队列已经满了返回false
        numbers.offer(1);
        System.out.println("更新后的PriorityQueue: " + numbers);
        numbers.offer(0);
        System.out.println("更新后的PriorityQueue: " + numbers);
        numbers.offer(5);
        System.out.println("更新后的PriorityQueue: " + numbers);

        //使用 peek() 方法
        int number = numbers.peek();
        System.out.println("访问元素: " + number);


        //使用poll()方法
        int number2 = numbers.poll();
        System.out.println("使用poll()删除的元素: " + number2);

        // 创建迭代器 迭代优先级队列
        Iterator<Integer> iterate = numbers.iterator();
        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }
    }
}

