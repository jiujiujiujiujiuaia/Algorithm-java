package algorithm.leetcode.RecursiveAndBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invert1(root);
        return root;
    }
    //递归 前序
    private void invert1(TreeNode root){
        if(root == null) return ;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = rightNode;
        root.right = leftNode;
        invert1(root.right);
        invert1(root.left);
    }
    //递归 后序
    private void invert2(TreeNode root){
        if(root == null ) return ;
        invert2(root.left);
        invert2(root.right);
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
    }
    //非递归方法
    private void noRecursive(TreeNode root){
        if(root!=null){
            Queue<TreeNode> queue = new LinkedList<>();
            ((LinkedList<TreeNode>) queue).add(root);
            while (queue.size()>0){
                TreeNode temp = ((LinkedList<TreeNode>) queue).pop();
                TreeNode leftNode = temp.left;
                TreeNode rightNode = temp.right;
                temp.left = rightNode;
                temp.right = leftNode;
                if(temp.right!=null) ((LinkedList<TreeNode>) queue).add(temp.right);
                if(temp.left!=null)((LinkedList<TreeNode>) queue).add(temp.left);
            }
        }

    }
}
