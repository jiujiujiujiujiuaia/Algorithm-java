package algorithm.leetcode.dp;

import java.util.ArrayList;
//300
//最大上升子序列
public class LIS {
    public int solution(int[] array){
        int[] dp = new int[array.length];
        int best = 0;
        int sort = 0;
        dp[0] = 1;
        for(int i = 1 ; i<array.length;i++){
            dp[i] = 1;
            for(int j = 0;j<i;j++){
               if(array[j]<array[i]){
                   dp[i] = Math.max(dp[i],dp[j]+1);
               }
            }
            if(dp[i]>best) {
                best = dp[i];
                sort = i;
            }
        }
        System.out.println("序列是:"+array[sort]);
        for(int i = sort;i>=0;i--){
            if((dp[sort]-1) == dp[i] && array[sort]>array[i]){
                System.out.println(array[i]);
                sort = i;
            }
        }
        return best;
    }
    //bug
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if(length == 0) return 0;
        int[] dp = new int[length];
        dp[0] =1;
        for(int i = 1 ;i <length;i++){
            dp[i] = 1;
            for(int j = 0 ;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            if(dp[i] < dp[i-1]){
                dp[i] = dp[i-1];
            }
        }
        return dp[length-1];
    }

    public static void main(String[] args){
        int[] array = {1,6,10,2,100,56,48,10,14,2,78,64};
        LIS lis = new LIS();
        System.out.println("长度为"+lis.solution(array));
    }

}
