package algorithm.leetcode.LinkedList;
//160
public class IntersectionOfTwoLinkedLists {
    class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA!=null&&headB!=null) {
            ListNode tempA = headA;
            ListNode tempB = headB;
            while (tempA != null && tempB != null) {
                tempA = tempA.next;
                tempB = tempB.next;
            }

            if (tempA == null && tempB !=null) {
                while (tempB != null) {
                    tempB = tempB.next;
                    headB = headB.next;
                }
            } else if(tempA != null && tempB ==null){
                while (tempA != null) {
                    tempA = tempA.next;
                    headA = headA.next;
                }
            }
            while (headA != null) {
                if (headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
}
