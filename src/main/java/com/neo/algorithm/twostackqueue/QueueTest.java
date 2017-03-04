package com.neo.algorithm.twostackqueue;

/**
 * Created by wenpeng on 2017/3/4.
 */
public class QueueTest {
    public static void main(String[] args) {
        TwoStackQueue<Integer> twoStackQueue = new TwoStackQueue();



        twoStackQueue.push(1);
        twoStackQueue.push(2);


        System.out.println(twoStackQueue.pop());
        twoStackQueue.push(3);
        System.out.println(twoStackQueue.pop());
        twoStackQueue.push(4);

        System.out.println(twoStackQueue.pop());
        System.out.println(twoStackQueue.pop());
//
//
//        System.out.println(twoStackQueue.pop());
    }
}
