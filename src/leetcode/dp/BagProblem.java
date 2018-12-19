package leetcode.dp;

/**
 * @Author yuchunwei
 * not in leetcode
 */
public class BagProblem {
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
    //优化上面的空间复杂度,虽然dp用的是一个二维数组，但是dp问题永远总是第i行的物品与i-1行的物品有关系
    //例如第2个物品依赖于第1个物品，用数组表示就是[0][]依赖于[1][] 第三个物品依赖于第二个物品 那就是[1][]依赖于[0][] 这样就达到了不断刷新数组而又不是循环遍历的效果了
    public int basicBagProblemOptimization(int c,int[] values,int[] weight){
        int[][] dp = new int[2][c+1];
        for(int m = 0;m<c + 1;m++){
            if(m>=weight[0]) {
                dp[0][m] = values[0];
            }
        }
        for(int i =1 ;i<values.length;i++){
            for(int j = 0 ; j < c + 1; j++){
                dp[i&1][j] = dp[(i-1)&1][j];
                if(j >= weight[i]){
                    dp[i&1][j] = Math.max( dp[i&1][j],values[i] +dp[(i-1)&1][j-weight[i]]);
                }
            }
        }
        return dp[(values.length-1) & 1][c];
    }
    //空间复杂度还可以进一步优化！
    public int basicBagProblemOptimizationMax(int c,int[] values,int[] weight){
        int[] dp = new int[c+1];
        for(int m = 0;m<c + 1;m++){
            if(m>=weight[0]) {
                dp[m] = values[0];
            }
        }
        //这一种是最优的空间，可以这样想象，每当新加入一个物品的时候，我们总是回去找旧物品的c-weight[i]位置的值，那么如果我们从C位开始遍历，到C>weight[i]为止
        //那么每次更新在旧的物品那一行，从后往前更新不会影响其他值
        for(int i =1 ;i<values.length;i++) {
            for (int j = c; j>=weight[i]; j--) {
                dp[j] = Math.max(dp[j],values[i]+dp[j-weight[i]]);
            }
        }

        return dp[c];

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
    //有一个特别聪明的做法就是，如果有一个物品i价值为1 重量为3 背包容量为18 对于dp[i][18]来说 本来要重复6次 6可以用二进制标识为2+4 那其实只用重复两次(任何数字都可以被二进制表示)
    public int completeBagProblem2(int c ,int[] values,int[] weight) {
        int[][] dp = new int[values.length][c + 1];
        int i;
        int counts;
        //预处理第一个物品，因为第一个物品只有一个选择 必选择
        for (int m = 0; m < c + 1; m++) {
            counts = m / weight[0];
            for (i = 0; i < counts; i ++) {
                dp[0][m] = counts * values[0];
            }
        }

        for (i = 1; i < values.length; i++) {
            for (int j = 0; j < c + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                counts = j / weight[i];
                for (int k = 1; k < counts + 1; ) {
                    dp[i][j] = Math.max(dp[i][j], k * values[i] + dp[i][j - k * weight[i]]);
                    k = k << 1;
                }
            }
        }
        return dp[values.length-1][c];
    }


    public static void main(String[] args) {
        int[] weight = {2,3,1,4,6,5};
        int[] value = {5,6,2,1,19,7};
//        int[] weight = {1,3,5};
//        int[] value = {1,2,3};
        BagProblem bag01 = new BagProblem();
        for(int i = 0 ; i < 100 ;i++){
            if(bag01.completeBagProblem(i,value,weight) != bag01.completeBagProblem2(i,value,weight))
                System.out.println("wrong:" + i);
        }

}
}   
