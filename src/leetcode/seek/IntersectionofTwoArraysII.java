package leetcode.seek;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author yuchunwei
 */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 = new HashMap();
        HashMap<Integer,Integer> map2 = new HashMap();
        for(int a : nums1){
            map1.put(a,(Integer)map1.getOrDefault(a,0) + 1);
        }
        for(int a : nums2){
            map2.put(a,(Integer)map2.getOrDefault(a,0) + 1);
        }
        return map1.size() > map2.size() ? handle(map2,map1):handle(map1,map2);
    }
    private int[] handle(HashMap<Integer,Integer> shortMap,HashMap<Integer,Integer> longMap){
        int[] res;
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry map : shortMap.entrySet()){
            if(longMap.containsKey(map.getKey())){
                for(int i = 0 ; i < (shortMap.get(map.getKey()) > longMap.get(map.getKey())
                        ? longMap.get(map.getKey()) : shortMap.get(map.getKey()) );i++){
                    list.add((Integer)map.getKey());
                }
            }
        }
        res = new int[list.size()];
        int i = 0;
        for(int a : list){
            res[i++] = a;
        }
        return res;
    }
    //简洁和简单多了
    public int[] intersect2(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map1 = new HashMap();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int a : nums1){
            map1.put(a,map1.getOrDefault(a,0) + 1);
        }
        for(int a : nums2){
            if(map1.containsKey(a) && map1.get(a) > 0){
                arrayList.add(a);
                map1.put(a,map1.get(a) - 1);
            }
        }
        int[] res = new int[arrayList.size()];int i = 0;
        for(Integer a : arrayList){
            res[i++] = a;
        }
        return res;
    }



    public static void main(String[] args) {

    }
}   
