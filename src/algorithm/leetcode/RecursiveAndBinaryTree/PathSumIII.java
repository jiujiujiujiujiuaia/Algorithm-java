package algorithm.leetcode.RecursiveAndBinaryTree;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author yuchunwei
 * algorithm.leetcode 437
 */
public class PathSumIII {
    //这个思路很棒 这个题改变了起始点 那么就摆再面前两个问题 选或者不选 然后pathSum负责遍历所有情况
    //pathFind负责以这个点为起点寻找路径个数
    private int res = 0 ;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        pathFind(root,sum);
        pathSum(root.left,sum);
        pathSum(root.right,sum);
        return res;
    }
    private void pathFind(TreeNode node , int sum){
        if(node == null) return ;
        if(sum == node.val) {
            res++;
        }
        pathFind(node.left,sum - node.val);
        pathFind(node.right,sum - node.val);
    }
    //hashmap+前缀和的办法o(n)级别的
    public int pathSum2(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        helper(root, 0, sum, preSum);
        return count;
    }
    int count = 0;
    private int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum,preSum.getOrDefault(currSum,0) + 1 ); //因为有可能有不同的路径获得同一个值

        res+= helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);//与数组不同 二叉树要回退一步
        return res;
    }
    public static void main(String[] args) {
        TreeNode node = BinaryTreeLevelsTraversal.buildTree(Arrays.asList(99,1,2,3,4,5,6,7));
        PathSumIII pathSumIII = new PathSumIII();
        pathSumIII.pathSum2(node,6);

    }
}
