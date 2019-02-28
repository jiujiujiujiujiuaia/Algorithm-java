package algorithm.leetcode.RecursiveAndBinaryTree;

/**
 * @Author yuchunwei
 * algorithm.leetcode 111
 * 这个题的递归终止条件就和112题一样 题目是叶子节点到根节点的最小值
 * 所以递归终止条件还要判断是不是一个叶子
 */
public class MinimumDepthofBinaryTree {
    private int minDepth(TreeNode root) {
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        if(root.left == null){
            return minDepth(root.right) + 1;
        }
        if(root.right == null){
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left),minDepth(root.right)) + 1;
    }
    public static void main(String[] args) {

    }
}
