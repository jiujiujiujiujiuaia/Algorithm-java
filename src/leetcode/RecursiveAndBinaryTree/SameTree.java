package leetcode.RecursiveAndBinaryTree;

/**
 * @Author yuchunwei
 * leetcode 100
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p !=null && q !=null){
            if(p.val != q.val) return false;
            if(isSameTree(p.left,q.left)){
                if(isSameTree(p.right,q.right)){
                    return true;
                }
                else return false;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
