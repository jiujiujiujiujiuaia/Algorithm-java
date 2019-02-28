package algorithm.leetcode.dp;

/**
 * @Author yuchunwei
 * algorithm.leetcode 198
 */
public class HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int[] dp = new int[n];
        dp[n-1] = nums[n-1];
        for(int i = n-2;i>=0;i--){
            dp[i] = Math.max(dp[i+1],nums[i]+(i+2<n ? dp[i+2] : 0));
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] a  = {2,7,9,3,1};
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(a));
    }
}   
