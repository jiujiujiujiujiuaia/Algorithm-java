package algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * @Author yuchunwei
 * 416
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0 ; i < nums.length;i++){
            sum+=nums[i];
        }
        if((sum&1) ==1) return false;
        boolean[] dp = new boolean[sum/2+1];
        for(int i = 0;i < dp.length;i++){
           dp[i] = (nums[0] == i) ;
        }
        for(int i = 1;i<nums.length;i++){
            for(int j = sum/2;j>nums[i];j--){
                dp[j] = dp[j] || dp[j-nums[i]];
            }
        }
        return dp[sum/2];
    }

    public static void main(String[] args) {

    }
}   
