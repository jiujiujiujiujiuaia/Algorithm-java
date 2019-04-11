package algorithm.newcoder.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author yuchunwei
 * 面试题46 数字翻译成字符串
 */
public class Code31 {

    //solution1 递归解决（未保存之前得值）
    public static int solve(int number){
       String str = String.valueOf(number);
       char[] chars = str.toCharArray();
       return help(chars,0);
     }

    private static int help(char[] chars,int start){
        if(start + 1 <= chars.length - 1){
            StringBuilder builder = new StringBuilder();
            builder.append(chars[start]);
            builder.append(chars[start+1]);
            if(Integer.valueOf(builder.toString()) < 26){
                return help(chars,start+2)+help(chars,start+1);
            }
            else return help(chars,start+1);
        }
        else {
            return 1;
        }
    }
    //solution2 保存值解决
    public static int solve2(int number){
        String str = String.valueOf(number);
        char[] chars = str.toCharArray();
        int[] counts = new int[chars.length];
        int count = 0;
        for(int i = chars.length - 1 ; i >=0 ;i--){
            int num = chars[i] - 48;
            if(i < chars.length - 1){
                count = counts[i+1];
                int res = num * 10 + chars[i+1] -48;
                if(res < 26 && res >9){
                    if(i < chars.length -2){
                        count+=counts[i+2];
                    }
                    else {
                        count++;
                    }
                }
                counts[i] = count;
            }
            else {
                counts[i] = 1;
            }

        }
        return counts[0];
    }

    public static void main(String[] args) {
        System.out.println(solve(12334543));
        System.out.println(solve2(12334543));
    }
}   
