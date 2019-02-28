package algorithm.leetcode.RecursiveAndBinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yuchunwei
 * algorithm.leetcode 129
 */
public class SumRoottoLeafNumbers {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        cal(root,"");
        return sum;
    }
    private void cal(TreeNode node ,String str){
        if(node == null) return ;
        str+=node.val;
        if (node.left == null &&  node.right == null) {
            sum+=Integer.parseInt(str);
            return;
        }
        cal(node.left,str);
        cal(node.right,str);
    }
    //solution2  效率更高 貌似是最优解
    public int sumNumbers2(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return sum * 10 + root.val;
        }

        return helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val);
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(99,1,2,3);
        TreeNode root = BinaryTreeLevelsTraversal.buildTree(list);
        SumRoottoLeafNumbers sumRoottoLeafNumbers = new SumRoottoLeafNumbers();
        sumRoottoLeafNumbers.sumNumbers(root);
    }
}
