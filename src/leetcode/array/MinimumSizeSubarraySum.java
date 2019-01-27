package leetcode.array;

import java.util.HashMap;

/**
 * @Author yuchunwei
 * leetcode 209
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int best = Integer.MAX_VALUE;
        int temp = 0;
        for(int i = 0 , j = 0 ; i < nums.length || j < nums.length;){
             if(temp < s && j !=nums.length -1 ) {
                temp+=nums[++j];
            }
            else if(temp > s ){
                best = Math.min(best,j - i);
                temp -=nums[i++];
            }
        }
        return best;
    }
}   
