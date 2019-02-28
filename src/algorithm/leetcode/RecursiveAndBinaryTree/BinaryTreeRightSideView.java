package algorithm.leetcode.RecursiveAndBinaryTree;

import java.util.*;

/**
 * @Author yuchunwei\
 * leetcode 199
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root) ;
        int cnt = 1 ;//每一层的节点数
        while (queue.size() > 0){
            TreeNode node = ((LinkedList<TreeNode>) queue).pop();

            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right !=null) {
                queue.add(node.right);
            }
            if(--cnt == 0){ //保存每一层节点数最后一个
                res.add(node.val);
                cnt = queue.size() ;
            }

        }

        return res;

    }
}   
