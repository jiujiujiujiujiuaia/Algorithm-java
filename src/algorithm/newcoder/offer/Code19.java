package algorithm.newcoder.offer;

import java.util.ArrayList;

/**
 * @Author yuchunwei
 * 二叉树的层序遍历
 */
public class Code19 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>(128);
        ArrayList<TreeNode> list = new ArrayList<>(128);
        if(root == null) return res;
        list.add(root);
        while (list.size() > 0){
            TreeNode node = list.remove(0);
            res.add(node.val);
            if(node.left !=null) list.add(node.left);
            if(node.right!=null) list.add(node.right);
         }
         return res;
    }
}   
