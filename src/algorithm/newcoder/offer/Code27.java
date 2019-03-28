package algorithm.newcoder.offer;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author yuchunwei
 * 最长上升字串
 */
public class Code27 {

    //"abcbaaycwb"
    public static int solve(String str){
        if(str.length() == 0) return 0;
        char[] chars = str.toCharArray();
       // StringBuilder builder = new StringBuilder();
        int[] indexs = new int[26];
        int maxLength  =  1;
        int[] dp = new int[chars.length];
        dp[0] = 1 ;
        Arrays.fill(indexs,-1);
        indexs[0] = 0;
        for(int i = 1 ; i < chars.length ;i++){
           int lastIndex = indexs[chars[i] - 97];
           if(lastIndex == -1 || i - lastIndex > dp[i-1]){
               dp[i] = dp[i-1] + 1;
           }
           else if( i - lastIndex <= dp[i-1]){
               dp[i] = i - lastIndex;
           }
            indexs[chars[i] - 97] = i;
            maxLength = Math.max(dp[i],maxLength);
        }
        return maxLength;
    }


    public static void main(String[] args) {
        String str = "arabcacfr";
        System.out.println(solve(str));
    }
}   
