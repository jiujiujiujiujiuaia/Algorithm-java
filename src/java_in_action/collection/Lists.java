package java_in_action.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author yuchunwei
 */
public class Lists {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        //ArrayList
        List<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.remove(0));
    }
}
