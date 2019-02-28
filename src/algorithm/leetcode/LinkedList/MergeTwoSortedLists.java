package algorithm.leetcode.LinkedList;

//leetcode 21
 class ListNode {
      int val;
     ListNode next;
      ListNode(int x) { val = x; }
  }

public class MergeTwoSortedLists {
     //非递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode node = new ListNode(0);
       ListNode head = node ;
       while(l1 != null && l2 !=null){
           if(l1.val < l2.val){
               node.next = l1;
               node = l1;
               l1 = l1.next;
           }
           else {
               node.next = l2;
               node = l2;
               l2 = l2.next;
           }
       }

       if(l1 == null) {
           node.next = l2;
       }
       else {
           node.next = l1;
       }
       return head.next;
    }

    //递归版本
    public ListNode mergeTwoLists2(ListNode l1,ListNode l2){
        ListNode listNode = new ListNode(0);
        ListNode head = listNode;
        help(l1,l2,head);
        return listNode.next;
    }
    private void help(ListNode l1,ListNode l2,ListNode head){
        if(l1 ==null){
            head.next = l2;
            return ;
        }
        if(l2 == null){
            head.next = l1;
            return ;
        }
        if(l1.val < l2.val){
            head.next = l1;
            head = l1;
            help(l1.next,l2,head);
        }
        else {
            head.next = l2;
            head = l2 ;
            help(l1,l2.next,head);
        }
    }
}
