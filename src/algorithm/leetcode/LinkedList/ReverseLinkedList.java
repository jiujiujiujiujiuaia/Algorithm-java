package algorithm.leetcode.LinkedList;

/**
 * @Author yuchunwei
 * algorithm.leetcode 206
 */
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    //迭代版本的反转链表
    //每一次把当前链表的下一个指向前一个，然后当前变为pre next变成cur
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
    //递归版本
    public ListNode reverseList2(ListNode head){
        return help(head,null);
    }
    private ListNode help(ListNode cur,ListNode pre){
        if(cur == null) return pre;
        ListNode next = cur.next;
        cur.next = pre;
        return help(next,cur);
    }

    public static void main(String[] args) {

    }
}   
