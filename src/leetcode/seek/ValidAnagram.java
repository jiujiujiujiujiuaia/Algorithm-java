package leetcode.seek;

import java.util.HashMap;

/**
 * @Author yuchunwei
 * leetcode 242
 */
public class ValidAnagram {
    //这道题目通解是这样解，如果字符集规定了只有26个字母的话用数组更快
    public boolean isAnagram(String s, String t) {
        if(s.length() == t.length()){
            HashMap<Character,Integer> map = new HashMap<>();
           char[] charS = s.toCharArray();char[] charT = t.toCharArray();
           for(char a : charS){
               map.put(a , map.getOrDefault(a , 0) + 1);
           }
           int temp;
           for(char a : charT){
               if(map.containsKey(a)){
                   if((temp = (map.get(a) - 1)) > 0){
                       map.put(a,temp);
                   }
                   else {
                       map.remove(a);
                   }

               }
           }
           return map.size() == 0 ? true : false;

        }
        else return false;
    }
}   
