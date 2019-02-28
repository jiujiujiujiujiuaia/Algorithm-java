package algorithm.leetcode.dp;

/**
 * @Author yuchunwei
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for(int i = 1;i<n+1;i++){
            dp[i] = 1;
            for(int j = 1;j<i;j++){
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),dp[j]*(i-j)));
            }
        }
        return dp[n];
     }

    public static void main(String[] args) {
        IntegerBreak integerBreak = new IntegerBreak();
        System.out.println(integerBreak.integerBreak(2));
    }
}   
