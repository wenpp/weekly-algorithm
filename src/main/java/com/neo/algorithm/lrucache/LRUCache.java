package com.neo.algorithm.lrucache;

import java.util.*;

/**
 * Created by wenpeng on 2017/3/1.
 * 设计一个算法满足:https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU
 * 支持两个方法put ,get
 * get(key) 获取值,没有返回-1
 * put(key,value) 添加值如果key不存在,如果达到了缓存的上线,移除最少使用的值
 *
 * 解决思路:
 * 使用一个链表来存储数据的key,再使用一个hash来存储key和Value。
 * 当调用get方法的时候,从hash中获取该key
 * 当调用put方法的时候,先判断是否已满，满了就移除头数据，在把最新的key插入链表的尾部，再把key和链表位置放入hash
 */
public class LRUCache {
    Map<Integer,Integer> valueMap = null;
    List<Integer> keyList = null;
    int size = 0;

    public LRUCache(int capacity) {
        keyList = new ArrayList<Integer>(capacity);
        valueMap = new HashMap<Integer, Integer>(capacity);
        size = capacity;
    }

    public int get(int key) {
        if(valueMap.containsKey(key)){
            //更新元素位置
            moveToHead(key);
            return valueMap.get(key);
        }
        return -1;
    }

    private void moveToHead(int key) {
        if(keyList.get(0)!=key){
            keyList.remove(new Integer(key));
            keyList.add(0,key);
        }
    }

    public void put(int key, int value) {
        if(keyList.contains(key)){
            moveToHead(key);
        }
        else if(keyList.size()>=size){
            removeEldest();
            keyList.add(0,key);
            valueMap.put(key,value);
        }else{
            keyList.add(0,key);
            valueMap.put(key,value);
        }
    }

    private void removeEldest() {
        int key = keyList.get(size-1);
        keyList.remove(size-1);
        valueMap.remove(key);
    }
}
