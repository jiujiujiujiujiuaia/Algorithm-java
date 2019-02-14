package leetcode.seek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author yuchunwei
 * leetcode 49
 * 诸如此类的问题 一定要和面试官沟通好 1字符集问题 2 空解的情况 3 返回结果的顺序问题
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>(); //map存的是List中的id
        int[] count = new int[26];
        for(String str : strs){
            Arrays.fill(count,0);
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int a : count){
                sb.append("#");
                sb.append(a);
            }
            String s = sb.toString();
            if(map.containsKey(s)) res.get(map.get(s)).add(str);
            else {
                List<String> temp = new ArrayList<>();
                temp.add(str);
                res.add(temp);
                map.put(s,res.size() - 1);
            }
        }
        return res;
    }
    //solution2 省去了对key拼接得开销 特别得有意思
    public  List<List<String>> groupAnagrams2(String[] strs) {
       //因为质数是不可以由其他数字相乘得到，因此利用质数相乘得到得积作为唯一得key
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

        List<List<String>> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}   
