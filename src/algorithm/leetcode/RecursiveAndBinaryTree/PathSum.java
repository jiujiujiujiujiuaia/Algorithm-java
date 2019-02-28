package algorithm.leetcode.RecursiveAndBinaryTree;

/**
 * @Author yuchunwei
 * algorithm.leetcode 112 这题的陷阱就是根节点到叶节点才算数 假设一个根节点没有左子树且根节点等于sum 那么其实
 * 是不能算true
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {

        if(root == null ){
            return false;
        }
        if (root.left == null && root.right == null) {
            if(root.val == sum ) return true;
            else return false;
        }
        return hasPathSum(root.left,sum - root.val) ||
                hasPathSum(root.right,sum - root.val);

    }


    public static void main(String[] args) {

    }
}
