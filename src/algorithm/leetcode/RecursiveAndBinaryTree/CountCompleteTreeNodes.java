package algorithm.leetcode.RecursiveAndBinaryTree;

import java.util.Arrays;

/**
 * @Author yuchunwei
 * algorithm.leetcode 222
 */
public class CountCompleteTreeNodes {
    //代码简洁些了但是效率有点低
    public int countNodes(TreeNode root) {
        int left = rightDepth(root);
        int right = leftDepth(root);
        if(left == right) return (1<<left)-1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private int rightDepth(TreeNode right){
        int depth = 0;
        while (right != null){
            depth++;
            right = right.right;
        }
        return depth;
    }
    private int leftDepth(TreeNode left){
        int depth = 0;
        while (left !=null){
            depth++;
            left = left.left;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode node = BinaryTreeLevelsTraversal.buildTree(Arrays.asList(99,1,2,3,4,5,6,null));
        CountCompleteTreeNodes countCompleteTreeNodes = new CountCompleteTreeNodes();
        countCompleteTreeNodes.countNodes(node);
    }
}   
