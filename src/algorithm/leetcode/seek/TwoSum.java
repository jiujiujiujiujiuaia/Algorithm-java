package algorithm.leetcode.seek;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
//algorithm.leetcode 1
public class TwoSum {
    //效率太低 O(n^2)的算法
    public int[] twoSum(int[] nums, int target) {
       for(int i = 0;i<nums.length;i++){
           for(int j = 0 ;j<nums.length;j++){
               if( i == j) break;
               if(nums[i] + nums[j] == target) {
                  Integer[] a =(Integer[])Arrays.asList(i,j).toArray();
                   return Arrays.stream(a).mapToInt(Integer::valueOf).toArray();
               }
           }
       }
       return null;
    }
    //这个方法不行 因为一旦排序后索引也变了 要返回原索引
    public int[] twoSum2(int[] nums, int target) {
        int i = 0;int j = nums.length-1;
        while(j>i){
            int temp = nums[j] + nums[i];
            if(temp > target)j--;
            else if(temp<target) i++;
            else return Arrays.stream((Integer[])Arrays.asList(i,j).toArray()).mapToInt(Integer::valueOf).toArray();
        }
        return null;
    }
    //使用hash的话插入和查询都和快 遍历一次就行 但是会有重值得情况，比如a[0] = 3 a[1] = 3 target = 6;如果map(value,key)会重复 map(key,value)会无法通过value找到key,
    //也可能找不到唯一得索引
    //但是下面这个办法简直了 最优解 算法得魅力 ！
    public int[] twoSum3(int[] nums, int target) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(!hashMap.containsKey(nums[i])) hashMap.put(target - nums[i],i);
            else return new int[]{hashMap.get(nums[i]),i};
        }
        return null;
    }


    public static void main(String[] args){
        HashMap<Integer,Integer> hashMap =new HashMap<>();

    }
}
