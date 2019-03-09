package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 把一颗二叉树变成镜像二叉树
 */
public class Code15 {

    public void Mirror(TreeNode root) {
        if(root == null) return ;

        Mirror(root.left);
        Mirror(root.right);

        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
    }
}   
