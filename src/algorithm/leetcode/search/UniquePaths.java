package algorithm.leetcode.search;
// 想法一 因为就两个方向，所以构造一个二叉树，然后把节点都存起来然后 看多少个根节点是重点的坐标，就可以输出多少条路径了
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] result = new int[n][m];
        for(int i=0,j =0;j<m;j++){
            result[i][j] = 1;
        }
        for(int i=0,j=0;i<n;i++){
            result[i][j] = 1;
        }
        for(int i =1;i<m;i++){
            for(int j =1;j<n;j++){
                result[j][i] = result[j-1][i]+result[j][i-1];
            }
        }
        return result[n-1][m-1];
    }

    public static void main(String[] args){
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(7,3));
    }

}
