package test;

import java.util.*;

public class Test {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6);
        List<Integer> sub = list.subList(1,4);
        System.out.println(sub);
        List<Integer> copy = (List<Integer>)((ArrayList<Integer>) list).clone();
        System.out.println(copy);
        copy.retainAll(sub);
        System.out.println(copy);
        Iterator it = list.iterator();
        while (it.hasNext()){
            int i = (int)it.next();
            it.remove();
        }
        System.out.println(list.isEmpty());

    }
}
