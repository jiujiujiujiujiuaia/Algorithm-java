package leetcode.dp;

/**
 * @Author yuchunwei
 */
public class CoinChange {
    //1 没有定义好状态 金币不满足的时候到底是什么状态
    //2 没有用优化空间的方法
    //3 无法使用滚动数组加位运算计算次数的方法,因为位运算计算次数需要拿第n个物品 从0到w重量的值，但是滚动数组必须从w开始
    //wrong 试图使用滚动数组加位运算
    public int coinChange(int[] coins, int amount) {
       if(amount !=0) {
            int[] dp = new int[amount + 1];

            for (int i = 0; i<= amount; i++) {
                if (i % coins[0] == 0) dp[i] = i / coins[0];
                else dp[i] =Integer.MAX_VALUE;
            }
            for (int i = 1; i < coins.length; i++) {
                for (int j = amount; j>=coins[i]; j--) {
                    int count = j / coins[i];
                    for (int m = 1; m <= count;) {
                        if (dp[j - m * coins[i]] < Integer.MAX_VALUE ){
                            dp[j] = Math.min(dp[j], m + dp[j - m * coins[i]]);
                        }
                        m = m<<1;
                    }
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
        else return 0;
    }
    //right 但是复杂度太高
    public int coinChange1(int[] coins, int amount) {
        if(amount !=0) {
            int[][] dp = new int[coins.length][amount + 1];

            for (int i = 0; i<= amount; i++) {
                if (i % coins[0] == 0) dp[0][i] = i / coins[0];
                else dp[0][i] =Integer.MAX_VALUE;
            }
            for (int i = 1; i < coins.length; i++) {
                for (int j = 0; j <= amount; j++) {
                    int count = j / coins[i];
                    dp[i][j] = dp[i - 1][j];
                    for (int m = 1; m <= count;m = m<<1) {
                        if (dp[i - 1][j - m * coins[i]] < Integer.MAX_VALUE ){
                            dp[i][j] = Math.min(dp[i][j], m + dp[i][j - m * coins[i]]);
                        }
                    }
                }
            }
            return dp[coins.length - 1][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length - 1][amount];
        }
        else return 0;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int c = 30;
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(coins,c));
    }
}   
