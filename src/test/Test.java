package test;

import java.util.*;

public class Test {
    private static Collection fill(Collection<String> collection){
        collection.add("dog");
        collection.add("cat");
        collection.add("dog");
        collection.add("rat");
        return collection;
    }

    private static Map fill(Map<String,String> map){
        map.put("rat","tom");
        map.put("cat","jerry");
        map.put("dog","david");
        map.put("dog","spot");
        return map;
    }
    public static void main(String[] args){
//        System.out.println(fill(new ArrayList<>()));
//        System.out.println(fill(new LinkedList<>()));
//        System.out.println(fill(new HashSet<>()));
//        System.out.println(fill(new TreeSet<>()));
//        System.out.println(fill(new LinkedHashSet<>()));
//        System.out.println(fill(new HashMap<>()));
//        System.out.println(fill(new TreeMap<>()));
//        System.out.println(fill(new LinkedHashMap<>()));
              Map map = new HashMap();
              map.put(1,"a");
              map.put(2,"b");
              map.put(3,"c");
              Set<Map.Entry> set = map.entrySet();
              Iterator<Map.Entry> iterator = set.iterator();
              while (iterator.hasNext()){
                  Map.Entry entry = iterator.next();
                  System.out.println(entry.getKey()+":"+entry.getValue());
              }

    }
}
