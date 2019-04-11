package algorithm.leetcode;

import java.util.HashMap;
import java.util.Iterator;

/**
 * @Author yuchunwei
 * leetcode 146 缓存机制
 */
class Node{
    Node next;
    Node pre;
    int key;
    int value;
    Node(int key,int value){
        this.key = key ;
        this.value = value;
    }
}

public class LRUCacheByLinkedNode {
    private final int capacity;
    private int count = 0 ;
    private Node head = new Node(0,0);
    private Node tail = new Node(-1,-1);
    private Node temp ;
    public LRUCacheByLinkedNode(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }
    public int get(int key) {
        Node dummyHead = head;
        while (dummyHead.next != tail){
            //如果存在，则先调换位置再返回
            if(dummyHead.next.key == key){
                Node node = dummyHead.next;
                delete(dummyHead,node.next);
                headInsert(node,head.next);

                temp = node;
                return node.value;
            }
            dummyHead = dummyHead.next;
        }
        return -1;
    }
    public void put(int key, int value) {
        if(capacity == 0) return;
        //如果是存在的值，则进行查询并更新
        int res = get(key);
        if(res != -1){
            temp.value = value;
            return ;
        }
        //如果超出了缓存最大值删除队尾的值
        if(count == capacity){
            delete(tail.pre.pre,tail);
            count--;
        }
        //插入头部
        Node newNode = new Node(key,value);
        headInsert(newNode,head.next);
        count++;
    }

    private void headInsert(Node newNode,Node next){
        head.next = newNode;
        newNode.pre = head;
        newNode.next = next;
        next.pre = newNode;
    }
    private void delete(Node pre,Node next){
        pre.next = next;
        next.pre = pre;
    }

}   
