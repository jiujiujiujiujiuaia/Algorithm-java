package algorithm.leetcode.RecursiveAndBinaryTree;


import java.util.Arrays;

/**
 * @Author yuchunwei
 * 序列和反序列二叉树（未通过）
 */
public class Test {
    private static int index = 0;

   public static String Serialize(TreeNode root) {
        if(root == null) return null;
        String res  = help(root,new StringBuilder());

        return res.substring(0,res.length() - 1);
    }
    private static String help(TreeNode root , StringBuilder builder){
        if(root == null) {
            builder.append("#,");
            return builder.toString();
        }

        builder.append(root.val + ",");

        help(root.left,builder);

        help(root.right,builder);

        return builder.toString();
    }

   public static TreeNode Deserialize(String str) {
        TreeNode root = null ;
        if(str ==null || str.equals("")) return root;
       root = help(str);
        return root;
    }
    private static TreeNode help(String str){
        String c  = Character.toString(str.charAt(index));
        TreeNode root = null ;

        if(!c.equals("#")) {
            root = new TreeNode(Integer.valueOf(c));
        }
        else {
            index+=2;
            return null;
        }
        index+=2;
        root.left = help(str);
        root.right = help(str);
        return root ;
    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeLevelsTraversal.buildTree(Arrays.asList(-100,1,2,3,4,5,6,7));
       String str = "1,2,4,#,#,5,#,#,3,6,#,#,7,#,#";
        Deserialize(str);
    }
}   
