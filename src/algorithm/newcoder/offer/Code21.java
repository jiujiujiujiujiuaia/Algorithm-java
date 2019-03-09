package algorithm.newcoder.offer;

import java.util.HashMap;
import java.util.Random;

/**
 * @Author yuchunwei
 *  复制复杂链表
 */


 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Code21 {

     //思路一 用时间换空间的思路 由于查询需要o（n^2）利用hashmap就减少复杂度
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null) return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode dummy = head;
        RandomListNode orignal = pHead;
        orignal = orignal.next;
        while (orignal !=null) {
            dummy.next = new RandomListNode(orignal.label);
            map.put(orignal,dummy.next);
            dummy = dummy.next;
            orignal = orignal.next;
        }
        dummy = head;
        while (pHead!=null){
            dummy.random = map.get(pHead.random);
            pHead = pHead.next;
            dummy = dummy.next;
        }
        return head;
    }

    //
}   
