package algorithm.leetcode.RecursiveAndBinaryTree;
//algorithm.leetcode 104
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    TreeNode(){

    }
}
public class MaximumDepthofBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right) + 1;
    }
}
