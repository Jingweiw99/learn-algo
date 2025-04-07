package com.wjw;

public class TheadTest {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.run();
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("__" + i);
        }
    }
}
