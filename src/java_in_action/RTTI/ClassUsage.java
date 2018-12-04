package java_in_action.RTTI;

import java.util.Random;
import java.util.RandomAccess;

/**
 * @Author yuchunwei
 */
class StaticClass{
    public static final int b = 2;
    public static final int c = new Random(48).nextInt(1000);
    static {
        System.out.println("it has been loaded");
    }
}

public class ClassUsage {

    public static void main(String[] args) throws Exception {
//        Class.forName("java_in_action.RTTI.StaticClass");
        Class a  = StaticClass.class;
        System.out.println(StaticClass.c);//这样却引起了类的初始化 ，访问b却不会引起类初始化
    }
}   
