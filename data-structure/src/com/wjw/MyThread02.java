package com.wjw;

public class MyThread02 {
    public static void main(String[] args) {
        Runnable mr = new MyRunnable();
        Thread t = new Thread(mr);
        t.start();
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            System.out.println("__" + i);
        }
    }
}
