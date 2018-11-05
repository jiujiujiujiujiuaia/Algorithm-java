package test;

import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<>();
    public void push(T v){storage.addFirst(v);}
    public T pop() {
        return storage.poll(); //poll方法返回并且移除第一个元素
    }
    public T peek(){
        return storage.peek();//返回并不移除
    }
}
class Queue<T>{
    private LinkedList<T> storage = new LinkedList<>();
    public void push(T v){storage.addLast(v);}
    public T pop(){return storage.poll();}
    public T peek(){return storage.peek();}
}
