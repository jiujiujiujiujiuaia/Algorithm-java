package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 删除链表中重复节点
 */
public class Code13 {
    //有两种删除链表中重复节点数，一种是完全删除，一种是留下重复节点的一个
    public ListNode deleteDuplication(ListNode pHead)
    {
        ListNode dummyHead = pHead;
        ListNode pre = null;
        while (dummyHead !=null) {
            if (dummyHead.next != null && dummyHead.next.val == dummyHead.val) {
                while (dummyHead.next != null && dummyHead.next.val == dummyHead.val) {
                    dummyHead = dummyHead.next;
                }
                pre.next = dummyHead.next;
                dummyHead = pre.next;
            }
            else {
                pre = dummyHead;
                dummyHead = dummyHead.next;
            }
        }
        return pHead;
    }

    public static void main(String[] args) {

    }
}   
