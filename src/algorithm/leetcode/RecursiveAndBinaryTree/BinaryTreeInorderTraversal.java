package algorithm.leetcode.RecursiveAndBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author yuchunwei
 */
public class BinaryTreeInorderTraversal {

    //迭代方法解决
    public List<Integer> inorderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        //((LinkedList<TreeNode>) queue).add(root);
        TreeNode p = root ;
        while(queue.size() > 0 || p !=null){
            //由于中序的特殊性，先把一个节点的左子树全部添加进来
            while(p!=null){
                ((LinkedList<TreeNode>) queue).addFirst(p);
                p = p.left;
            }
            //迭代到底后，有两种情况，最底下的那个节点是叶子节点或者该节点有右子树
            if(queue.size() > 0){
                TreeNode node = ((LinkedList<TreeNode>) queue).pop();
                if(node!=null) {
                    list.add(node.val);
                    if(node.right != null) p = node.right ;

                }
            }
        }
        return list ;
    }
}   
