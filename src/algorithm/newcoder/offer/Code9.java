package algorithm.newcoder.offer;

import java.util.Stack;

/**
 * @Author yuchunwei
 * 用两个栈模拟队列
 */
public class Code9 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (stack1.size() > 0){
            Integer a = stack1.pop();
            stack2.push(a);
        }
        stack1.push(node);
        while (stack2.size() > 0){
            Integer a = stack2.pop();
            stack1.push(a);
        }
    }

    public int pop() {
        return stack1.pop();
    }
}   
