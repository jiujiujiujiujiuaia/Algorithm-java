package algorithm.leetcode.dp;

/**
 * @Author yuchunwei
 * leetcode 718 最长重复子数组(类似于最长公共子串)
 */
public class MaximumLengthofRepeatedSubarray {

    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int max = 0 ;
        for(int i = 1 ; i <= A.length ;i++ ){
            for(int j = 1 ; j <= B.length ;j++){
                if(A[i -1 ] != B[j -1]) continue;
                dp[i][j] = dp[i-1][j-1] + 1;
                max = Math.max(max,dp[i][j]);
            }
        }
        return max;
    }


    public static void main(String[] args) {

    }
}   
