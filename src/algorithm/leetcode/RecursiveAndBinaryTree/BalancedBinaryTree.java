package algorithm.leetcode.RecursiveAndBinaryTree;

/**
 * @Author yuchunwei
 * algorithm.leetcode 110
 */
public class BalancedBinaryTree {
    private final int UNREACH = -99;
    //莫名奇妙这个方法还挺快，但是这个方法重复计算了很多
    //但是自底向上查看子树是否是平衡二叉树，一旦否就不再计算直接输出，根据后序遍历满足这个思想
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(maxDepth(root.left) - maxDepth(root.right)) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepth(TreeNode node){
        if(node == null) return 0;
        return Math.max(maxDepth(node.left),maxDepth(node.right)) + 1;
    }
    //第二种方法就用了这种思路，只遍历每个节点一次
    public boolean isBalanced2(TreeNode root){
        if(cal(root) == UNREACH) return false;
        else return true;

    }
    //一旦有某个子树不是平衡二叉树 就直接返回并且不再计算
    private int cal(TreeNode node){
        if(node == null) return 0;
        int l = cal(node.left);
        int r = cal(node.right);
        if(l == UNREACH || r == UNREACH || Math.abs(l - r) > 1) return UNREACH;
        return Math.max(l,r) + 1;
    }

    public static void main(String[] args) {

    }
}
