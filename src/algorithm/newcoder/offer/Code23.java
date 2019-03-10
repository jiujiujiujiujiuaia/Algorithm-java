package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 序列化二叉树
 */
public class Code23 {

    private int index = 0;

    String Serialize(TreeNode root) {
        if(root == null) return null;
        String res  = help(root,new StringBuilder());

        return res.substring(0,res.length() - 1);
    }
    private String help(TreeNode root , StringBuilder builder){
        if(root == null) {
            builder.append("#,");
            return builder.toString();
        }

        builder.append(root.val + ",");

        help(root.left,builder);

        help(root.right,builder);

        return builder.toString();
    }

    TreeNode Deserialize(String str) {
        TreeNode root = null ;
        if(str ==null || str.equals("")) return root;
        root = help(str);
        return root;
    }
    private TreeNode help(String str){
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
}   
