package DataStructure.SymbolTable.base_linked_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//基于链表的顺序查找的符号表
public class SequentialSearch<K,V> {

    private Node first;
    private int length;

    //构造链表数据结构
     class Node{
        private K key ;
        private V value;
        private Node next;
        Node(K key,V value,Node next){
            this.key = key ;
            this.value = value;
            this.next = next;
        }
    }
    //symbol table get方法
    public V get(K key){
       for(Node temp = first;temp!=null;temp = temp.next){
           if(temp.key.equals(key)){
               return temp.value;
           }
       }
        return null ;
    }
    //symbol table put 方法
    public void put(K key,V value){
        for(Node temp = first; temp !=null ;temp = temp.next){
            if(temp.key.equals(key)){
                temp.value = value;
                return ;
            }
        }
        first = new Node(key,value,first);
        length++;
    }

    public int size(){
         return length;
    }

    public Iterable<K> keys(){
        List<K>  list = new ArrayList<>();
        for(Node temp = first; temp !=null ;temp = temp.next){
            list.add(temp.key);
        }
        return list;
    }
    @Override
    public String toString(){
         String result = "size:"+size()+"\n";
        for(Node temp = first; temp !=null ;temp = temp.next){
            result = result+"key:"+temp.key+" value:"+temp.value+"\n";
        }
        return result;
    }


    public static void main(String[] args){
        SequentialSearch<Integer,String> sequentialSearch = new SequentialSearch<>();
        sequentialSearch.put(1,"a");
        sequentialSearch.put(2,"b");
        sequentialSearch.put(3,"c");
        Iterator<Integer> a = sequentialSearch.keys().iterator();
//        while(a.hasNext()){
//            System.out.println(a.next());
//        }



    }
}
