package algorithm.newcoder.offer;

import algorithm.leetcode.RecursiveAndBinaryTree.BinaryTreeLevelsTraversal;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author yuchunwei
 * 二叉树中寻找路径和
 */
public class Code20 {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        help(root,target,new ArrayList<>());
        return res;
    }
    private void help(TreeNode root, int target, ArrayList<Integer> list){
        if(root == null) return ;
        list.add(root.val) ;
        if(root.val == target && root.left == null && root.right == null) {//题目要求是叶子节点
            res.add((ArrayList<Integer>)list.clone());
        }
        help(root.left,target - root.val,list);
        help(root.right,target - root.val,list);
        list.remove(list.size() - 1);//记得回退，因为只用了一个list引用
    }

    public static void main(String[] args) {

    }
}
