package leetcode;

import java.util.Arrays;
//821
public class ShortestDistancetoaCharacter {
    //solution1 not best
    public int[] shortestToChar(String S, char C) {
        int start = 0,end = 0,j=1;
        int[] result = new int[S.length()];
        char[] chars = S.toCharArray();
        for(int i = 0 ;i<S.length();i++){
            result[i] = 1;
            if(chars[i] == C){
                result[i] = 0;
                start = end;
                end = i;
                if(result[start] == 0){
                    caculate(start,end,result);
                }
                else{
                    fill(start,end,result);
                }
            }
        }
        if(end != S.length()-1){
            for(int i = end+1;i<S.length();i++){
                result[i] = j;
                j++;
            }
        }

        return result;

    }
    private void caculate(int start, int end,int[] result){
        int j =0;
        int mid = start+(end-start)/2;
        if((end-start)%2 == 0){
            for(;start<end;start++,end--){
                result[start] = j;
                result[end] = j;
                j++;
            }
            result[mid] = j;
        }
        else{
            for(;start<end;start++,end--){
                result[start] = j;
                result[end] = j;
                j++;
            }
        }
    }
    private void fill(int start, int end,int[] result){
        int j = 1;
        for(int i = end-1;i>=start;i--){
            result[i] = j;
            j++;
        }
    }
    // solution2 best O(N)
     public int[] shortestToChar2(String S, char C) {
            int N = S.length();
            int[] ans = new int[N];
            int prev = Integer.MIN_VALUE / 2;

            for (int i = 0; i < N; ++i) {
                if (S.charAt(i) == C) prev = i;
                ans[i] = i - prev;
            }

            prev = Integer.MAX_VALUE / 2;
            for (int i = N-1; i >= 0; --i) {
                if (S.charAt(i) == C) prev = i;
                ans[i] = Math.min(ans[i], prev - i);
            }

            return ans;
        }

    public static void main(String[] args){
        ShortestDistancetoaCharacter shortestDistancetoaCharacter = new ShortestDistancetoaCharacter();
        String S = "lovletcode";char C = 'e';
        int[] res = shortestDistancetoaCharacter.shortestToChar(S,C);
        for(int a :res){
            System.out.println(a);
        }
    }
}
