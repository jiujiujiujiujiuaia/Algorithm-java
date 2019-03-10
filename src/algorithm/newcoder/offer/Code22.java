package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 二叉搜索树和双向链表（未通过）
 */
public class Code22 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        if(pRootOfTree.left == null && pRootOfTree.right == null) return pRootOfTree;

        TreeNode left = Convert(pRootOfTree.left);
        if(left !=null) {
            left.right = pRootOfTree;
            pRootOfTree.left = left;
        }

        TreeNode right = Convert(pRootOfTree.right);
        if(right !=null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }

        return null;
    }
}   
