package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 重建二叉树
 */



   class TreeNode {
       int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Code7 {
    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return recursion(pre,0,pre.length - 1,in,0 ,in.length - 1);
    }

    private static TreeNode recursion(int [] pre ,int preL,int preR,int[] in ,int inL, int inR){

        if(preL > preR || inL > inR){
            return null;
        }

        TreeNode node = new TreeNode(pre[preL]);
        for(int i = 0 ; i < in.length ;i ++){
            if(in[i] == pre[preL]){
                node.left = recursion(pre,preL+1,preL + i - inL,in,inL,i-1);
                node.right = recursion(pre,i - inL + preL + 1,preR,in,i+1,inR);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        reConstructBinaryTree(new int[]{1,2,3,4,5,6,7},new int[]{3,2,4,1,6,5,7});
    }
}   
