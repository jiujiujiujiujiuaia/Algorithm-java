package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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

    public static void test(Integer[] a ){
        a[0] = 10;
    }

    public static void read() {

        String string = null;
        try {
            // 在给定从中读取数据的文件名的情况下创建一个新 FileReader
            FileReader fr = new FileReader("C:\\Users\\yuchunwei\\Desktop\\a.in");

            // 创建一个使用默认大小输入缓冲区的缓冲字符输入流
            BufferedReader br = new BufferedReader(fr);

            while (null != (string = br.readLine())) {
                System.out.println(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void write(){
        try{
            FileWriter fr = new FileWriter("C:\\Users\\yuchunwei\\Desktop\\b.in"    );
            BufferedWriter bw = new BufferedWriter(fr);
            for(int i = 0;i<10;i++){
                bw.write("我会写入文件啦\r\n");
            }
            bw.flush();
            bw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
//        System.out.println(fill(new ArrayList<>()));
//        System.out.println(fill(new LinkedList<>()));
//        System.out.println(fill(new HashSet<>()));
//        System.out.println(fill(new TreeSet<>()));
//        Systemter.out.println(fill(new LinkedHashSet<>()));
////        System.out.println(fill(new HashMap<>()));
////        System.out.println(fill(new TreeMap<>()));
////        System.out.println(fill(new LinkedHashMap<>()));
//
////              Map map = new HashMap();
////              map.put(1,"a");
////              map.put(2,"b");
////              map.put(3,"c");
////              Set<Map.Entry> set = map.entrySet();
////              Iator<Map.Entry> iterator = set.iterator();
//              while (iterator.hasNext()){
//                  Map.Entry entry = iterator.next();
//                  System.out.println(entry.getKey()+":"+entry.getValue());
//              }
//            read();
//        String a = "1 2 3 4 5 6";
//        String[] b = a.split(" ");
//        for(String c :b){
//            System.out.println(c);
//        }
//        write();
    }

}
