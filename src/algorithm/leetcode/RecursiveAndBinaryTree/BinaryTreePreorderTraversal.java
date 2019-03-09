package algorithm.leetcode.RecursiveAndBinaryTree;

import middleware.A;

import java.util.*;

/**
 * @Author yuchunwei
 * 144
 树的前中后迭代遍历要用栈
 */
public class BinaryTreePreorderTraversal {

    //递归
    private List<Integer> res = new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {
        recursion(root);
        return res;
    }

    private void recursion(TreeNode root){
        if(root == null ) return ;
        res.add(root.val) ;

        recursion(root.left);
        recursion(root.right);
    }
    //迭代
    public List<Integer> preorderTraversal2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return null;
        ((LinkedList<TreeNode>) queue).add(root);
        while (queue.size() > 0 ){
            TreeNode node = ((LinkedList<TreeNode>) queue).pop();
            if(node != null) {
                list.add(node.val);
                ((LinkedList<TreeNode>) queue).addFirst(node.right);
                ((LinkedList<TreeNode>) queue).addFirst(node.left);
            }
            else continue;
        }
        return list ;
    }
}   
