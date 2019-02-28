package algorithm.leetcode.RecursiveAndBinaryTree;

import java.util.*;

/**
 * @Author yuchunwei
 * not in algorithm.leetcode 二叉树的层次遍历
 */
public class BinaryTreeLevelsTraversal {
    //bfs进行二叉树的层次遍历
    private static void bfs(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).add(node);
       while (queue.size() > 0){
           TreeNode treeNode = ((LinkedList<TreeNode>) queue).pop();
           if(treeNode == null ) continue;
           System.out.println(treeNode.val);
           ((LinkedList<TreeNode>) queue).add(treeNode.left);
           ((LinkedList<TreeNode>) queue).add(treeNode.right);
       }
    }
    private static void dfs(TreeNode head){
        List<String> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        String str = "";
        while (stack.size() > 0){
            TreeNode node = stack.pop();
            if(node == null) continue;
            System.out.println(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }

    }
    //这个buildTree函数是了为验证上面层次遍历的方法对不对写（也可以自己从根节点手动一个add，但是那太蠢了不是）
    //为了简化问题，我假设list是从索引1开始的
    //且为了简化，我也没有对lists进行判断，也就是说要求list一定要是一个正确的list
    public static TreeNode buildTree(List<Integer> lists){
        TreeNode head = new TreeNode(lists.get(1));
        Queue queue = new LinkedList();
        ((LinkedList) queue).add(head);
        for(int  i = 1 ;i < lists.size() ; i = i<<1){
            for(int j = i ; j < i<<1 ;j++){
                if( j * 2 >= lists.size()) break;
               TreeNode node = (TreeNode) ((LinkedList) queue).pop();
               node.left = new TreeNode(lists.get(j*2));
               node.right = new TreeNode(lists.get(j*2+1));
               ((LinkedList) queue).add(node.left);
               ((LinkedList) queue).add(node.right);
            }
        }
        return head;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-100,1,2,3,4,5,6,7);
        dfs(buildTree(list));
    }
}
