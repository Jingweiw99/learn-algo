package com.wjw.RandomSet;

import java.util.*;

/*
常数时间O（1），插入，删除，获取随机元素
 */
public class RandomSet {
    private HashMap<Integer, Integer> valToIndex;
    private List<Integer> data;
    private Random rand;

    RandomSet() {
        valToIndex = new HashMap<>();
        data = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) {
            return false;
        }
        valToIndex.put(val, data.size());
        data.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) {
            return false;
        }
        int index = valToIndex.get(val);
        int lastElement = data.get(data.size() - 1);
        valToIndex.put(lastElement, index);
        Collections.swap(data, index, data.size() - 1);
        data.remove(data.size() - 1);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return data.get(rand.nextInt(data.size()));
    }

    public static void main(String[] args) {
        RandomSet randomSet = new RandomSet();
        System.out.println(randomSet.insert(1));// true 表示插入成功
        System.out.println(randomSet.remove(2)); // false 表示删除失败
        System.out.println(randomSet.insert(2)); // true
        System.out.println(randomSet.getRandom()); // 随机返回一个值 1 2 中的一个
        System.out.println(randomSet.remove(1));// true
        System.out.println(randomSet.insert(2)); // false 已经存在了插入失败
        System.out.println(randomSet.getRandom()); // 2

    }
}
