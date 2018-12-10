package jvm.classLoad;

/**
 * @Author yuchunwei
 */
public class StaticClass {
    static {
        System.out.println("StaticClass has been loaded !!");
    }
    public static int a =  1;

    public static void main(String[] args) {

    }
}   
