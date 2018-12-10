package leetcode.dp;

/**
 * @Author yuchunwei
 * not in leetcode
 */
public class Bag01 {
    //这还是一个最大累积的问题，比较不选择当前问题 和 选择当前物品+选择了当前物品后剩下重量的最优解
    //每刷完一次内循环后，都是物品范围的[0.index]最优解
    //同时 这里的时间复杂度无法优化 但是空间复杂度可以从两行依赖 到一行依赖这个思路优化
    public int basicBagProblem(int c ,int[] values,int[] weight){
        int[][] dp = new int[values.length][c+1];
        for(int m = 0;m<c + 1;m++){
            if(m>=weight[0]) {
                dp[0][m] = values[0];
            }
        }
        for(int i =1 ;i<values.length;i++){
            for(int j = 0 ; j < c + 1; j++){
                dp[i][j] = dp[i-1][j];
                if(j >= weight[i]){
                    dp[i][j] = Math.max( dp[i][j],values[i] +dp[i-1][j-weight[i]]);
                }
            }
        }

        return dp[values.length-1][c];

    }
    //完全背包问题，也就是说每一个物品可以不限量的选取
    //这个思路就是把完全背包问题转化成了背包问题 只不过是每次还有一个循环把次序用完
    //最直观的转化是 用重量除物品i的重量，得到最多能装j个i，然后循环把物品表扩充j个物品的价值和质量，就等价于解决了01背包问题
    public int completeBagProblem(int c ,int[] values,int[] weight){
        int[][] dp = new int[values.length][c+1];
        int i ;
        int counts;
        //预处理第一个物品，因为第一个物品只有一个选择 必选择
        for(int m = 0;m< c+1;m++){
            counts = m/weight[0];
            for(i = 0 ;i <counts;i++){
                dp[0][m] = counts * values[0];
            }
        }

        for(i = 1; i<values.length;i++){
            for(int j = 0;j<c+1;j++){
                dp[i][j] = dp[i-1][j];
                counts = j/weight[i];
                for(int k = 1;k<counts+1;k++){
                    dp[i][j] = Math.max(dp[i][j],k*values[i]+dp[i-1][j-k*weight[i]]);
                }
            }
        }

        return dp[values.length-1][c];
    }
    //更进一步的优化在于

    public static void main(String[] args) {
        int[] weight = {2,3,1,4,6,5};
        int[] value = {5,6,2,1,19,7};
//        int[] weight = {1,2,3};
//        int[] value = {4,5,6};
        Bag01 bag01 = new Bag01();
        System.out.println(bag01.completeBagProblem(100,value,weight));
    }
}   
