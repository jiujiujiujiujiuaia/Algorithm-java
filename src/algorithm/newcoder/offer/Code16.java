package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 对称二叉树
 */
public class Code16 {
    //题目不难 注意非递归的解法
    public boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null) return true;

        return help(pRoot.left,pRoot.right);
    }
    private boolean help(TreeNode right,TreeNode left){
        if((right ==null && left !=null) || (right !=null && left ==null) ) return false;
        if(right == null && left == null) return true;
        if((right !=null && left !=null) &&(right.val ==left.val)) return help(right.left,left.right) && help(right.right,left.left);
        return false;

    }
}   
