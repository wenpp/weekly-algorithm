package com.neo.algorithm.lrucache;

/**
 * Created by wenpeng on 2017/3/1.
 */
public class Test {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

//        cache.put(1, 1);
//        cache.put(2, 2);
//
//        System.out.println(cache.get(1));
//        cache.put(3, 3); //移除2
//        System.out.println(cache.get(2)); //-1
//        cache.put(4, 4); //移除
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(3));
//        System.out.println(cache.get(4));

        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));

        cache.put(1, 5);
        cache.put(1, 2);

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
