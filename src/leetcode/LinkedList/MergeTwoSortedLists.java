package leetcode.LinkedList;
 class ListNode {
      int val;
     ListNode next;
      ListNode(int x) { val = x; }
  }

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 != null && l2 != null) {
            ListNode listNode;
            ListNode head = new ListNode(0);
            if (l1.val < l2.val) {
                listNode = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                listNode = new ListNode(l2.val);
                l2 = l2.next;
            }
            head.next = listNode;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    listNode.next = l1;
                    l1 = l1.next;
                    listNode = listNode.next;
                } else {
                    listNode.next = l2;
                    l2 = l2.next;
                    listNode = listNode.next;
                }
            }
            if (l1 == null) {
                while (l2 != null) {
                    listNode.next = l2;
                    l2 = l2.next;
                    listNode = listNode.next;
                }
            } else {
                while (l1 != null) {
                    listNode.next = l1;
                    l1 = l1.next;
                    listNode = listNode.next;
                }
            }
            return head.next;
        }
        else if(l1 == null){
            return l2;
        }
        else return l1;
    }
}
