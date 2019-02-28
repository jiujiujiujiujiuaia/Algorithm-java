package algorithm.leetcode.seek;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author yuchunwei
 * algorithm.leetcode 451
 * 这个题目特别有意思，hashmap只能存储键和值，无法再根据值排序，这里使用了桶排序，桶的编号就是其出现次数
 * 然后就相当于根据值进行了排序
 */
public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        ArrayList<Character>[] lists = new ArrayList[s.length()];
        for(char a : s.toCharArray()){
            map.put(a,map.getOrDefault(a,0)+ 1);
        }
        for(Character a : map.keySet()){
            int frequency = map.get(a);
            if(lists[frequency] == null) lists[frequency] = new ArrayList<>();
            lists[frequency].add(a);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() ; i >= 0 ;i--){
            if(lists[i] !=null){
                for(Character a : lists[i]){
                    for(int j = 0 ; j < i ;j++){
                        sb.append(a);
                    }
                }
            }
        }

        return sb.toString();
    }

}   
