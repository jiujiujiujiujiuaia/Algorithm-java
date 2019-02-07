package leetcode.seek;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author yuchunwei
 * leetcode 349
 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for(int a : nums1){
            set.add(a);
        }
        for(int b : nums2){
            if(set.contains(b)){
                resultSet.add(b);
            }
        }
        int[] res = new int[resultSet.size()];
        int i = 0;
        for(Integer c : resultSet ){
            res[i++] = c;
        }
        return  res;
    }

    public static void main(String[] args) {

    }
}   
