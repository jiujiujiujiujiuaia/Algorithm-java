package leetcode;

/**
 * @Author yuchunwei
 * leetcode 206
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode cur,next,pre = null;
        cur = head ;
        while(cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;

    }

    public static void main(String[] args) {

    }
}   
