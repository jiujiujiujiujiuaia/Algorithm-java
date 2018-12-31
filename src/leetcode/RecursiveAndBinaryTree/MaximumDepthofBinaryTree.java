package leetcode.RecursiveAndBinaryTree;
//leetcode 104
class TreeNode {
    Integer val;
    TreeNode left;
    TreeNode right;
    TreeNode(Integer x) { val = x; }
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
