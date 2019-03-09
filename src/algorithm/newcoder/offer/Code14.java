package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 链表中倒数第k个节点
 */
public class Code14 {

    //这道题首先思路很巧妙，普通解法都是遍历两次，而这种解法只需要遍历一次
    //先有一个指针遍历，然后两个指针一起遍历，前指针停止了，说明了就走到了
    //其次是对各种情况的分析，题目没有说一定有倒数K的数，那么就要考虑K的情形
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k == 0) return null;
        int count = k - 1;
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i = 0 ; i < count ;i++){
            if(p1 == null) return null;
            p1 = p1.next;
        }
        if(p1 == null) return null;
        while (p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {

    }
}   
