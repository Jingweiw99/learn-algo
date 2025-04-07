package com.wjw.design.prototype.demo03;

/*
浅克隆
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Citation citation = new Citation();
        Student student = new Student();
        student.setName("wjw");
        citation.setStudent(student);

        Citation c1 = citation.clone();

        Citation c2 = citation.clone();

        System.out.println(c2.getStudent() == c1.getStudent()); // true

        Citation c3 = citation.deepClone();
        System.out.println(citation.getStudent() == c3.getStudent()); // false 已经深克隆了
    }
}
