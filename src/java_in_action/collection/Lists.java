package java_in_action.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yuchunwei
 */
public class Lists {
    public static void main(String[] args) {
        System.out.println("start");
        List<Integer> list = new LinkedList<>();
        ((LinkedList<Integer>) list).addFirst(1);
        ((LinkedList<Integer>) list).addFirst(1);
        ((LinkedList<Integer>) list).addFirst(1);
        ((LinkedList<Integer>) list).addFirst(1);
        ((LinkedList<Integer>) list).addFirst(1);
        System.out.println(" current size " + list.size());
        ((LinkedList<Integer>) list).peek();
        System.out.println("after peek" + list.size());

        System.out.println(" current size " + list.size());
        ((LinkedList<Integer>) list).poll();
        System.out.println("after poll" + list.size());
        System.out.println(list.remove(0));
    }
}
