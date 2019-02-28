package algorithm.leetcode.array;

import java.util.HashMap;

/**
 * @Author yuchunwei
 * algorithm.leetcode 209
 * 双指针之滑动窗口解法
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int best = Integer.MAX_VALUE;
        int temp = 0;
        for(int i = 0 , j = -1 ; i < nums.length - 1 || j < nums.length - 1;){
             if(temp < s && j !=nums.length - 1  ) {
                temp+=nums[++j];
            }
            else if(temp >= s ){
                best = Math.min(best,j - i + 1);
                temp -=nums[i++];
            }
            else {
                 break;
             }
        }
        return best;
    }
}   
