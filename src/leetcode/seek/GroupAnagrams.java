package leetcode.seek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author yuchunwei
 * leetcode 49
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        boolean[] query = new boolean[strs.length];
        HashMap[] maps = new HashMap[strs.length];
        List<List<String>> res = new ArrayList<>();
        for(int k = 0 ; k < strs.length ; k++){


        }
        for(int i = 0 ; i < strs.length ; i++){
            if(!query[i]){
                String target = strs[i];
                query[i] = true ;
                List<String> list = new ArrayList<>();
                HashMap<Character,Integer> hashMap = new HashMap<>();
                for(int j = i + 1 ; j < strs.length ; j++){

                }
            }
        }
    }

    public static void main(String[] args) {

    }
}   
