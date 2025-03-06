package com.wjw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
测试ArrayList的底层实现
add方法主要实现 首先调用ensureCapacityInternal
size是ArrayList内部数据的大小
确保内部需不需要扩容，如果需要就扩容，并将数据复制到扩容的新数组中
然后放数据，
最后返回结果
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!! 后来增加了修改次数
        elementData[size++] = e;
        return true;
    }

ArrayList底层是用动态数组实现的
ArrayList初始容量为0，无参的构造，第一次添加数据的时候会初始化容量为10
添加数据每次检查内部需要的最小容量和和当前内部保存数据的数组容量，
如果最小容量大于旧容量，扩容，
扩容的逻辑是：扩容为原来的1.5倍，然后复制数据

 */
public class ArrayListTest {
//    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        for (int i = 2; i <= 10; i++) {
//            list.add(i);
//        }
//        list.add(11);
//    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Integer[] nums = list.toArray(new Integer[list.size()]);
//        Integer[] nums1 = (Integer[]) nums; 注意这里不能直接转 否则异常

        for (Integer num : nums) {
            System.out.println(num);
        }
        List<Integer> list1 = Arrays.asList(nums);
        System.out.println(list1);
    }
}
