package algorithm.newcoder.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yuchunwei
 * 打印分开的字符串
 */
public class Code3 {

    public static void solve(String string){
        char[] chars = string.toCharArray();
        String res = "";
        for(int i = 0 ; i < chars.length ; i++){
            if(chars[i] != ' ') {
                res+=chars[i];
            }
            else {
                if(!res.equals(""))    System.out.println(res);
                while (i + 1 < chars.length && chars[i+1] == ' '){  //像这种循环一定要判断是否越界
                    i++;
                }
                res = "";
            }
        }
        if(!res.equals(""))    System.out.println(res);
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("  123 1 234");
        list.add("123  ");
        list.add("  1 2 3  ");
        list.add("  12 34  ");
        list.add("");
        list.add("  ");
        list.add("  12 34  ");
        for(int i = 0 ; i < list.size() ; i++){
            System.out.println("第"+ i +"次输出");
            solve(list.get(i));
        }

    }
}   
