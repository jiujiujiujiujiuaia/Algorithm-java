package leetcode.RecursiveAndBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author yuchunwei
 * leetcode 101
 */
public class SymmetricTree {
    //solution1 ac是ac了但是思路有点复杂
    //对于判断一棵二叉树是否对称，有点和其他的不一样，因为不能从根节点开始递归，要从第二层节点开始递归
    //也就是说 第二层的两个结点值必须要相同，但是第三层的头两个和后两个不一定要相等！
    public boolean isSymmetric(TreeNode root) {
        if(root == null)  return true;
        return  isSubSymmetric(root.left,root.right);

    }

    private boolean isSubSymmetric(TreeNode left,TreeNode right){
        if(left == null && right == null ) return true;
        if(left == null || right == null ) return false;
        if(left.val == right.val){
            if(isSubSymmetric(left.right,right.left)){
                return isSubSymmetric(left.left ,right.right);
            }
            else return false;
        }
        return false;
    }
    //solution2
    //官方的思路基本和我一样，但是代码要比我清爽很多很多 ！但是说明我还是聪明啊
    public boolean isSymmetric2(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }
    //非递归的解法
    public boolean isSymmetric3(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}   
