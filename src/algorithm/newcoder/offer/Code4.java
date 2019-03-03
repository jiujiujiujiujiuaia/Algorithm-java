package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 在中序遍历的过程中，任意给一个节点，请返回它的下一个节点
 */


 class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}


public class Code4 {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        TreeLinkNode node = null;
        if(pNode.right != null) {
            //如果一个节点有右孩子，不需要向上找，向下即可以找到
            TreeLinkNode temp = pNode.right;
            while(temp.left !=null){
                temp = temp.left;
            }
            node = temp;
        }
        else if(pNode.next !=null){
            //如果一个节点没有右孩子，那么下一个节点一定要向上找
            //如果这个节点没有父亲，输出Null，如果有父亲且是父亲的左孩子，下个节点就是父亲
            //如果是父亲的右孩子，要一直向上寻找知道其父亲是别人的左孩子
            TreeLinkNode parent = pNode.next;
            while(parent != null && parent.right == pNode){
                pNode = parent ;
                parent = parent.next ;
            }
            node = parent;
        }
        return node;
    }
}   
