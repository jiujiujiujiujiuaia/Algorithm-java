package algorithm.leetcode.RecursiveAndBinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yuchunwei
 * algorithm.leetcode 257
 */
public class BinaryTreePaths {
    private List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        cal(root,"");
        return result;
    }
    private void cal(TreeNode node,String str){
        if(node == null) return ;

        if(node.left == null && node.right == null) {
            result.add(str + node.val);
            return ;
        }
        str += node.val + "->" ;
        cal(node.left,str);
        cal(node.right,str);
    }

    public static void main(String[] args) {

    }
}
