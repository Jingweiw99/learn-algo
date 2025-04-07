package com.wjw.design.prototype.demo03;

import java.io.*;

public class Citation implements Cloneable, Serializable {
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void show() {
        System.out.println(student.getName() + "同学，这是你的奖状！");
    }

    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    // 深克隆（需要自定义实现）
    // 使用对象流和文件流来实现对象的深度拷贝
    // try() 可以自动释放资源
    public Citation deepClone() throws Exception {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("1.txt"));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("1.txt"));) {
            oos.writeObject(this);
            return (Citation) ois.readObject();
        }
    }
}
