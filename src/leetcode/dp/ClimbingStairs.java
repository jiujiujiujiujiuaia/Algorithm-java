package leetcode.dp;

/**
 * @Author yuchunwei
 *  leetcode 70
 */
public class ClimbingStairs {
    private int[] result ;
    public int climbStairs(int n) {
        if(n !=0) {
            result = new int[n + 1];
            result[1] = 1;
            return climb(n);
        }
        return 0;
    }
    private int climb(int n){
        if(n == 0) return 1;

        if(result[n] == 0){
            result[n] = climb(n-1) + climb(n-2);
            return result[n];
        }
        return result[n];
    }

    public static void main(String[] args) {
        ClimbingStairs climbingStairs =  new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs(5));
    }
}   
