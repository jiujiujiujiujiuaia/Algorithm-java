package algorithm;

import com.google.common.collect.TreeBasedTable;
import java_in_action.FatherProtected;

import java.util.concurrent.CountDownLatch;

/**
 * @Author yuchunwei
 */
public class Test implements  Runnable {
    private static int  i = 0 ;

    public static void test3(){
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        System.out.println(c == (a + b));
        Integer e = 200;
        Integer f = 200;
        Integer g = 400;
        System.out.println(g == (e + f));
        System.out.println(g.equals(e+f));
        Integer i = Integer.valueOf(300);
        Integer j = Integer.valueOf(300);
        System.out.println(i == j);
        byte pp = 1;
        short ll = pp;
    }

    public static void test2(){
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c==d);
        System.out.println(e==f);
        System.out.println(c==(a+b));
        System.out.println(c.equals(a+b));
        System.out.println(g==(a+b));
        System.out.println(g.equals(a+b));
        System.out.println(g.equals(a+h));
    }

    public static void test(){

        Double i1 = 100.0;
        Double i2 = 100.0;
        Double i3 = 200.0;
        Double i4 = 200.0;
        int i = 10000;
        Long l = (long)i;
        Byte a = 1;
        System.out.println(i1==i2);
        System.out.println(i3==i4);
    }

    public static void testStringAndInteger(){
       Integer ii = new Integer(57);
       Integer ll = 57;
        System.out.println(ii == ll);
        System.out.println("-----------");
        Integer i1 = new Integer(97);
        Integer i2 = new Integer(97);
        System.out.println(i1 == i2); //false
        System.out.println(i1.equals(i2));
        System.out.println("-----------");

        Integer i3 = new Integer(197);
        Integer i4 = new Integer(197);
        System.out.println(i3 == i4); //false


        Integer i5 = 97;
        Integer i6 = 97;
        System.out.println(i5 == i6);
        System.out.println("-----------");        //true

        Integer i7 = 197;
        Integer i8 = 197;
        System.out.println(i7 == i8);            //false
        System.out.println("字符串");
        System.out.println("-----------");
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println("-----------");
        String s3 = new String("abc");
        System.out.println("-----------");
        String s4 = new String("abc");
        String s5 = "abc";
        System.out.println(s4 == s5);
        System.out.println(s4.equals(s5));
        System.out.println("-----------");
        String s6 = "a" + "b" + "c";
        String s7 = "abc";
        System.out.println(s6 == s7);
        System.out.println(s6.equals(s7));
        System.out.println("-----------");
        String s8 = "ab";
        String s9 = "abc";
        String s10 = s8 + "c";
        System.out.println(s10 == s9);
        System.out.println(s10.equals(s9));

    }

    public static void testString(){
        boolean res ;
        System.out.println("-------demo1----------");
        String str1 = new String("hello world");
        String str2 = "hello world";
        res =  str1 == str2 ;
        System.out.println("str1 == str2 -> " +res);

        System.out.println("-------demo2----------");
        String a = "hello world";
        String b = "hello world" ;
        res =   a == b ;
        System.out.println("a == b -> " + res);
        System.out.println("-------demo3----------");

        System.out.println("请问以下代码创建了几个对象");
        String str3 = new String("abc");

        System.out.println("-------demo4----------");
        String s1 = "hello" + " world";
        String s2 = "hello world";
        res = s1 == s2;
        System.out.println("hello + world == hello world -> "+res);

        System.out.println("-------demo5----------");
        String s3 = "hello";
        String s4 = "hello world";
        res =  (s3+" world") == s4;
        System.out.println("hello+s3 == s4 -> " +res);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();


    }
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    @Override
    public void run() {
        synchronized (this) {
            for (int j = 0; j < 100000; j++) {
                System.out.println(i);
                i++;
            }
            countDownLatch.countDown();
        }
    }

    public static void main(String[] args) throws Exception{
        Test test = new Test();
        Thread thread1 = new Thread(test);
        thread1.start();
       Thread.sleep(1000);
        for (int j = 0; j < 100000; j++) {
            System.out.println("---------------");
            i++;
        }
        countDownLatch.await();
        System.out.println(i);
    }
}   
