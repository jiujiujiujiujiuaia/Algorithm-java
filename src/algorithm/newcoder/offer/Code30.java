package algorithm.newcoder.offer;

import edu.princeton.cs.algs4.In;

import java.util.Stack;

/**
 * @Author yuchunwei
 * 把数组排成最小的数
 */
public class Code30 {

    public static String PrintMinNumber(int [] numbers) {
        for(int i = 0 ; i < numbers.length ;i++){
            for(int j = i ;j < numbers.length ;j++){
                if(compare(numbers[i],numbers[j])) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for(int a : numbers){
            builder.append(a);
        }
        return builder.toString();
    }

    //自定义比较规则
    //如果两个数字一模一样返回false 不交换
    //如果两个数字第一位相同，且位数不同，则比较第二位与第一位，如1，123和2，213
    //如果两个数字第一位不同，那么肯定小的在前面
    private static boolean compare(int i ,int j ){
        Stack<Integer> stacki = new Stack<>();
        Stack<Integer> stackj = new Stack<>();
        while (i > 0) {
            stacki.push(i % 10);
            i/=10;
        }
        while (j > 0){
            stackj.push(j % 10);
            j/=10;
        }
        int a = 0;
        int b = 0;
        while (stacki.size() > 0 || stackj.size() > 0){
            if(stacki.size() > 0) a = stacki.pop();
            if(stackj.size() > 0) b = stackj.pop();
            if(a > b){
                //exchange
                return true;
            }
            else if(a < b) {
                //not exchange
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
       int[] array = {1};
        System.out.println(PrintMinNumber(array));
    }
}   
