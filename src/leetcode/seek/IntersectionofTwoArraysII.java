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
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int[] res = new int[nums1.length > nums2.length ? nums1.length : nums2.length];
        for(int a : nums1){
            hashMap.put(a,hashMap.getOrDefault(a,0) + 1);
        }
        for(int b : nums2){
            if(hashMap.containsKey(b)){
                hashMap.put(b,hashMap.get(b) - 1);
            }
        }
        int i = 0;
        for(Map.Entry entry : hashMap.entrySet()){
            if((Integer)entry.getValue() == 0){
                res[i++] = (int)entry.getKey();
            }
        }
        return res;
    }


    public static void main(String[] args) {

    }
}   
