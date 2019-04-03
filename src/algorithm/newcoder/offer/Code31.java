package algorithm.newcoder.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author yuchunwei
 * 面试题46 数字翻译成字符串(未解)
 */
public class Code31 {

    public int solve(int number){
        if(number < 10) return 1;
        Stack<Integer> stack = new Stack<>();
        while (number > 0){
            stack.add(number % 10);
            number /= 10;
        }
        int[] array = new int[stack.size()];
        int[] dp = new int[array.length];
        int i = 0 ;
        while (stack.size() > 0){
            array[i] = stack.pop();
            i++;
        }
        dp[0] = 1;
        for(i = 1 ; i < array.length ;i++){

        }
        return 1;
    }

    public static void main(String[] args) {

    }
}   
