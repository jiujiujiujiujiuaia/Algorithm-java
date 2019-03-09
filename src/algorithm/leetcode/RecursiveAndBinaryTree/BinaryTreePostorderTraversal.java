package algorithm.leetcode.RecursiveAndBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author yuchunwei
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode lastNode = null ;
        while (root !=null){
            ((LinkedList<TreeNode>) queue).addFirst(root);
            root = root.left;
        }
        //后序迭代关键点在于，如果一个节点是叶子，那么要把它保存下来，然后看它父亲有没有右节点，且上一个节点是不是他左儿子
        //如果满足的话，把父节点再一次保存，然后遍历右子树
        //如果父节点没有右子树，则直接输出父亲再回退
        while(queue.size() > 0){
            TreeNode node = ((LinkedList<TreeNode>) queue).pop();
            if(node.right !=null && node.left == lastNode){
                ((LinkedList<TreeNode>) queue).addFirst(node);
                TreeNode right = node.right;
                while(right!=null) {
                    ((LinkedList<TreeNode>) queue).addFirst(right);
                    right = right.left;
                    //关键点 当切换到右子树了 上一次和本次无关 要变成Null
                    lastNode = null;
                }
            }
            else if(node != null){
                res.add(node.val);
                lastNode = node ;
            }
        }
        return res;
    }
}   
