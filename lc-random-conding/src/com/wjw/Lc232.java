package com.wjw;

import java.util.Stack;

/*
使用栈实现队列
void push(int val);
int pop();
int peek();
boolean empty();
给两个栈，s1和s2 s2栈push的是时候直接添加，s1作为中转反向获取s2的元素，
然后peek pop 就是对应队列的顺序了。
只有两者都是empty的时候empty为true
 */
public class Lc232 {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    public Lc232() {
        this.s1 = new Stack<>();
        this.s2 = new Stack<>();
    }
     public void push(int val) {
         s2.push(val);
     }

     public int peek(){
         // 实际弹出的栈为空的情况下需要添加
         if(s1.isEmpty()){
             while(!s2.isEmpty()) {
                 s1.push(s2.pop());
             }
         }
         return s1.peek();
     }
    public int pop() {
        // 实际弹出的栈为空的情况下需要添加
        peek();
        return s1.pop();
    }
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        Lc232 test = new Lc232();
        test.push(1);
        test.push(2);
        int a = test.peek();
        System.out.println(a); // 1
        test.pop();
        System.out.println(test.empty()); // false
        System.out.println(test.pop()); // 2
        System.out.println(test.empty()); // true
    }
}
