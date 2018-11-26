package leetcode;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root){
        if(root == null) return ;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = rightNode;
        root.right = leftNode;
        invert(root.right);
        invert(root.left);
    }
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
