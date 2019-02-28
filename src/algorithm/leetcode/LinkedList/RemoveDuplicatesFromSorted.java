package algorithm.leetcode.LinkedList;

/**
 * @Author yuchunwei
 * leetcode 83
 */
public class RemoveDuplicatesFromSorted {
   static class ListNode {
        int val;
       RemoveDuplicatesFromSorted.ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head ;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }
            else {
                cur = cur.next;
            }
        }
        return head ;
    }


    public static void main(String[] args) {
    }
}   
