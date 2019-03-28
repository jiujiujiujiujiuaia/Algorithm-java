package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 连续子数组的最大和
 */
public class Code25 {

    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0) return 0;
        int[] dp = new int[array.length];
        int max = array[0];
        for(int i = 0 ; i < array.length; i++){
            dp[i] = Math.max(array[i],(i-1 < 0 ? 0 : dp[i-1]) + array[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] a = {-2,-8,-1,-5,-9};
        FindGreatestSumOfSubArray(a);
    }
}   
