package algorithm.leetcode.dp;

/**
 * @Author yuchunwei
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] =1;
        for(int i = 1; i <=target ;i++ ){
            for(int j = 0 ;j<nums.length;j++){
                if(i>=nums[j]){
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {

    }
}   
