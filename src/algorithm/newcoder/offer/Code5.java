package algorithm.newcoder.offer;

import algorithm.leetcode.LinkedList.ReverseLinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yuchunwei
 * 从尾到头打印链表
 */


      class ListNode { int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
     }


public class Code5 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        recurison(listNode,res);
        return res;

    }
    private void recurison(ListNode node, List<Integer> res){
        if(node !=null){
            recurison(node.next,res);
            res.add(node.val);
        }
    }
}   
