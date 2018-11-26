package leetcode.dp;

import java.util.ArrayList;

public class LIS {
    public int solution(int[] array){
        int[] dp = new int[array.length];
        int best = 0;
        int sort = 0;
        for(int i = 0 ; i<array.length;i++){
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

    public static void main(String[] args){
        int[] array = {1,6,10,2,1,100,3,7,4,8,5,16};
        LIS lis = new LIS();
        System.out.println("长度为"+lis.solution(array));
    }

}
