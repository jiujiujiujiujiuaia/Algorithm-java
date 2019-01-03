package leetcode.RecursiveAndBinaryTree;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yuchunwei
 */
public class PathSumII  {
    //solution1 思路没有问题 就是没有用好api 没有处理好如存储内部的list 所以麻烦了一点
    private List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        cal(root,sum,"");
        return lists;
    }
    private void cal(TreeNode node , int sum ,String str){
        if(node == null) return ;
         if(node.left == null && node.right == null && sum == node.val){
             util(str+node.val);
         }
         str+=node.val+",";
        cal(node.left , sum - node.val,str);
        cal(node.right,sum - node.val,str);
    }
    private void util(String str){
        List<Integer> list = new ArrayList<>();
        String[] strings = str.split(",");
        for(String s : strings){
            list.add(Integer.parseInt(s));
        }
        lists.add(list);
    }
    //solution2 这个解法效率高太多了 并且解决了存放list中节点回退的问题
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        cal(root,sum,res,cur);
        return res;
    }
    private void cal(TreeNode  node,int sum ,List<List<Integer>> res,List<Integer> cur){
        if(node == null ) return ;

        if(node.left == null && node.right == null && sum == node.val){
            List<Integer> list = new ArrayList<>(cur);//为了优雅点牺牲空间而不是
                                                        // 在这里再 cur.remove(cur.size() - 1);
            list.add(node.val);
            res.add(list);
            return ;
        }
        cur.add(node.val);
        cal(node.left,sum - node.val,res,cur);
        cal(node.right,sum - node.val,res,cur);
        cur.remove(cur.size() - 1); //后序遍历回退根节点
    }
}
