package com.wjw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/*
插入删除的时间复杂度为O（1）
随机获取元素的时间复杂度为O（1）

思路：随机返回一个值 我想到动态数组，通过size的random，取get一下，随机返回时间复杂度为O（1）
但是数组insert  remove的时间复杂度为O(n)
那么需要额外获取直接获取这个索引index？？？   如何获取  具体看remove的实现
 */
public class RandomizedSet {
    public static void main(String[] args) {
        RandomizedSet test = new RandomizedSet();
        System.out.println(test.remove(0));
        System.out.println(test.remove(0));
        System.out.println(test.insert(0));

        System.out.println(test.getRandom());

        System.out.println(test.remove(0));

        System.out.println(test.insert(0));

    }

    Random random = new Random();
    HashMap<Integer, Integer> valToIndex; // 实际的值对数组中的索引
    List<Integer> arr; // 存储外界的值

    public RandomizedSet() {
        this.valToIndex = new HashMap<>();
        this.arr = new ArrayList<>();
    }

    // 插入如果不存在 插入成功true  失败返回false
    boolean insert(int val) {
        // 如果没有包含 我们需要 需要再valToIndex添加，arr最后面添加
        if (!valToIndex.containsKey(val)) {
            arr.add(val);
            valToIndex.put(val, arr.size() - 1);
            return true;
        }
        return false;
    }

    // 删除如果成功删除 true
    boolean remove(int val) {
        // 如果删除的val不存在 返回false
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int index = valToIndex.get(val);
        // 注意这里不能直接删除val
        int end = arr.size() - 1;
        int endVal = arr.get(end);
        int curVal = arr.get(index);
        arr.set(end, curVal);
        arr.set(index, endVal);
        // 需要将原来curVal的映射删除， 最后一个endVal的映射更新
        valToIndex.put(endVal, index);
        valToIndex.remove(curVal);
        // 删除最后一个位置 时间复杂度为O(1)，更新一下index endVal的映射
        arr.remove(end);
        return true;
    }

    // 相同概率随机返回集合中的一项
    int getRandom() {
        return arr.get(random.nextInt(arr.size()));
    }
}
