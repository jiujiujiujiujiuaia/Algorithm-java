package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yuchunwei
 */
public class LRUCacheByHash {

    private final int capacity;
    private final Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    private int count;

    public LRUCacheByHash(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            node = new Node(key, value);
            if (count == 0) {
                head = node;
                tail = node;
                count++;
            } else if (count == capacity) {
                cache.remove(tail.key);
                if (capacity == 1) {
                    head = node;
                    tail = node;
                } else {
                    tail.pre.next = null;
                    tail = tail.pre;

                    node.next = head;
                    head.pre = node;
                    head = node;
                }
            } else {
                node.next = head;
                head.pre = node;
                head = node;
                count++;
            }
            cache.put(key, node);
        }
    }

    private void moveToHead(Node node) {
        if (node == head) {
            return;
        }
        if (node == tail) {
            tail = node.pre;
        }
        node.pre.next = node.next;
        if (node.next != null) {
            node.next.pre = node.pre;
        }
        head.pre = node;
        node.next = head;
        node.pre = null;
        head = node;
    }


}   
