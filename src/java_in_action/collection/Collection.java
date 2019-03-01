package java_in_action.collection;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @Author yuchunwei
 */
public class Collection {

    private static void testList(){
        System.out.println(" LinkedList start");
        List<Integer> list = new LinkedList<>();
        ((LinkedList<Integer>) list).addFirst(1);
        ((LinkedList<Integer>) list).addFirst(1);
        ((LinkedList<Integer>) list).addFirst(1);
        ((LinkedList<Integer>) list).addFirst(1);
        ((LinkedList<Integer>) list).addFirst(1);
        list.remove(1);
        System.out.println(" current size " + list.size());
        ((LinkedList<Integer>) list).peek();
        System.out.println("after peek" + list.size());

        System.out.println(" current size " + list.size());
        ((LinkedList<Integer>) list).poll();
        System.out.println("after poll" + list.size());
        System.out.println(list.remove(0));
    }

    private static void testSet(){
        Set set = new HashSet();
        for(int i = 0 ; i < 10 ;i++){
            set.add(i) ;
        }
        for(Object a : set){
            System.out.println(a);
        }
        System.out.println("hashset按照添加顺序保存");

    }



    public static void main(String[] args) {
        testSet();
    }
}
