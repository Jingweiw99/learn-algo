package com.wjw.stack;

import java.util.LinkedList;

public class MyLinkedListStack<E> {

    private LinkedList<E> data = new LinkedList<E>();

    public static void main(String[] args) {
        // push 1 2 3 peek  pop peek
        MyLinkedListStack<Integer> stack = new MyLinkedListStack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop()); // 3
        System.out.println(stack.peek()); // 2
        System.out.println(stack.size()); // 2
        System.out.println(stack.pop()); // 2
        System.out.println(stack.peek()); // 1
        System.out.println(stack.size()); // 1
        System.out.println(stack.pop()); // 1
//        System.out.println(stack.peek()); // 报错
        System.out.println(stack.size()); // 0
    }

    public void push(E e) {
        data.addLast(e);
    }

    public E pop() {
        return data.removeLast();
    }

    public E peek() {
        return data.get(data.size() - 1);
    }

    public int size() {
        return data.size();
    }

}
