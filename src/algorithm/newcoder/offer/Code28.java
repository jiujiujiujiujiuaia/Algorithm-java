package algorithm.newcoder.offer;

import edu.princeton.cs.algs4.In;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author yuchunwei
 * 第一个只出现一次的字符
 */
public class Code28 {

    public int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map = new HashMap<>(128);
        for(Character a : str.toCharArray())
        {
            map.put(a,map.getOrDefault(a,0) + 1);
        }
       int i = 0;
        for(Character a : str.toCharArray()){
            if(map.get(a) == 1){
                return i;
            }
            i++;
        }

        return -1;
    }

    public static void main(String[] args) {

    }
}   
