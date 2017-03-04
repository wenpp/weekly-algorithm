package com.neo.algorithm.twostackqueue;

import java.util.Stack;

/**
 * Created by wenpeng on 2017/3/2.
 * 使用栈来模拟队列的效果,实现pop和peek方法
 *
 * 思路:
 * 栈式先进后出，队列是先进先出
 * 需要两个栈来模拟队列的效果，第一个栈正常的，先入的压到最下面，第二个栈用来反序的把数据压入。当获取数据数据的时候就从第二个栈获取数据，先压入的数据就会先出
 */
public class TwoStackQueue<T> {
    private Stack<T> stackPush;
    private Stack<T> stackPop;

    public TwoStackQueue() {
        this.stackPush = new Stack<T>();
        this.stackPop = new Stack<T>();
    }

    //压入时候更新弹出栈
    public void push(T t){
        stackPush.add(t);
        modifyStack(stackPush, stackPop);
    }


    public T pop(){
        //弹出时候更新压入
        T popValue = stackPop.pop();
        modifyStack(stackPop,stackPush);
        return popValue;
    }

    private void modifyStack(Stack<T> source,Stack<T> end){
        if(source.empty()){
            end.clear();
            return;
        }

        end.clear();

        for(int i=source.size();i>0;i--){
            T headValue = source.elementAt(i-1);
            end.add(headValue);
        }
    }

    private void modifyStackPop(Stack<T> stackpush) {
        if(stackpush.empty()){
            throw new RuntimeException("StackPush is empty");
        }

        stackPop.clear();

        for(int i=stackpush.size();i>0;i--){
            T headValue = stackpush.elementAt(i-1);
            stackPop.add(headValue);
        }
    }

    private void modifyStackPush(Stack<T> stackpop) {
        if(stackpop.empty()){
            throw new RuntimeException("StackPop is empty");
        }

        stackPush.clear();

        for(int i=stackpop.size();i>0;i--){
            T headValue = stackpop.elementAt(i-1);
            stackPush.add(headValue);
        }
    }

    public T peek(){
        return stackPop.peek();
    }

    private void modifyStackPop() {
        if(stackPop.isEmpty()){
            addStackPop(stackPush);
        }else{
            clearStackPop();
            addStackPop(stackPush);
        }
    }

    private void addStackPop(Stack<T> stackpush) {
        for(int i=stackpush.size();i>0;i--){
            T headValue = stackpush.elementAt(i-1);
            stackPop.add(headValue);
        }
    }

    private void clearStackPop() {
        stackPop.clear();
    }

}
