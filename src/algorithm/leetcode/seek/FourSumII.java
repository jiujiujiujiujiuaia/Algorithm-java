package algorithm.leetcode.seek;

import java.util.HashMap;

/**
 * @Author yuchunwei
 * algorithm.leetcode 454
 */
public class FourSumII {

    //由于题目透露出了每个数组的数据量大小不超过500 那么暴力的解法超过了一亿肯定是不可能的 遍历ABC寻找D复杂度是o(n^3)
    //也是不可能的，自然而然想到是O(n^2)次方级别的算法
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            int res = 0;
            HashMap<Integer,Integer> hashMap = new HashMap<>();
            for(int i = 0 ; i < C.length ; i++){
                for(int j = 0 ; j < D.length ; j++){
                    int temp = C[i] + D[j] ;
                    hashMap.put(temp , hashMap.getOrDefault(temp , 0) + 1);
                }
            }
            for(int k = 0 ; k < A.length ; k++){
                for(int n = 0 ; n < B.length ; n++){
                    int target = - (A[k] + B[n]);
                    if(hashMap.containsKey(target)) res+=hashMap.get(target);
                }
            }
            return res;
    }

    public static void main(String[] args) {

    }
}   
