package com.wjw;

import java.util.Scanner;

/*
next和nextLine的区别
next遇到空格,制表符，换行符停止读取
nextLine 读取整行，直到遇到换行符

next 不会消耗换行符！！！ 混用的时候需要再后面加上in.nextLine();
nextLine 会读取并消耗换行符
 */
public class Test {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        System.out.println(in.nextInt());
//        System.out.println("+++" + in.nextLine()); // 最后换行符也算上了
////        in.nextLine();
//        System.out.println(in.nextInt());

//        test6();

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一句话：");

        String word = scanner.next();
        System.out.println("您输入的第一个单词是：" + word);

        String word2 = scanner.next();
        System.out.println("您输入的第2个单词是：" + word2);

        scanner.close();
    }

    public static void test1() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // 默认获取的是String类型的
        System.out.println("你输入的字符串是" + str);
        while (sc.hasNext()) {
            String str2 = sc.next();
            System.out.println("输入的是：" + str2);
        }
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // 默认获取的是String类型的
        System.out.println("你输入的字符串是" + str);
        if (sc.hasNext()) {
            String str2 = sc.next();
            System.out.println("输入的是：" + str2);
        }
        sc.close();
    }

    public static void test3() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            System.out.println("输入的是：" + str); // Line可以接收空格开头的
        }
        sc.close();
    }

    public static void test4() {
        // 整数和浮点数的测试
        Scanner sc = new Scanner(System.in);
//        System.out.print("请输入一个整数：");
//        if (sc.hasNextInt()) {
//            int i = sc.nextInt();
//            System.out.println("你输入的整数是:" + i);
//        } else {
//            System.out.println("你输入的" + sc.nextLine() + "不是一个整数！");
//        }
        System.out.print("请输入一个小数:"); // 这里float 或者double表示小数
        if (sc.hasNextDouble()) {
            double v = sc.nextDouble(); // 如果输入的是int类型会自动转为 float
            System.out.println("你输入的小数是:" + v);
        }
    }

    // 输入多个数字 最后计算和
    public static void test5() {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        System.out.print("请输入一个数字:");
        while(sc.hasNextDouble()) {
            sum += sc.nextDouble();
            System.out.print("请输入一个数字:");
        }
        System.out.println(sum);
    }

    public static void test6(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入多行内容，输入 'exit' 结束：");

        StringBuilder inputText = new StringBuilder();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("exit")) {
                break;
            }
            inputText.append(line).append("\n");
        }

        System.out.println("您输入的内容是：");
        System.out.println(inputText.toString());

        scanner.close();
    }
}
