package algorithm.newcoder.offer;

import java.util.LinkedList;

/**
 * @Author yuchunwei
 * 构建一个O（1） 查询最小值的 pop出最小值的栈
 */
public class Code18 {
    private LinkedList<Integer> statck = new LinkedList<>();
    private LinkedList<Integer> help = new LinkedList<>();
    private int min = Integer.MAX_VALUE;

    public void push(int node) {
        statck.addFirst(node);
        if(node < min) {
            min = node;
        }
        help.addFirst(min);
    }

    public int top() {
        help.removeFirst();
        return  statck.removeFirst();
    }

    public void pop() {
        statck.removeFirst();
        help.removeFirst();
    }

    public int min() {
        return help.peek();
    }
}   
