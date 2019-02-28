package algorithm.leetcode.dp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author yuchunwei
 * algorithm.leetcode 474
 */
public class OnesandZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int [] ms = new int[strs.length];
        int [] ns = new int[strs.length];
        for(int i =0; i<strs.length;++i){
            String s = strs[i];
            for(int j=0; j<s.length();++j){
                char c = s.charAt(j);
                if(c=='0')++ms[i];
                else ++ns[i];
            }
        }
        int[][] dp = new int[m+1][n+1];
        for(int k = 0 ;k<ms.length;k++) {
            for (int i = m; i>=ms[k]; i--) {
                for (int j = n; j >=ns[k]; j--) {
                    dp[i][j] = Math.max(dp[i][j],dp[i-ms[k]][j-ns[k]]+1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
    }
}   
