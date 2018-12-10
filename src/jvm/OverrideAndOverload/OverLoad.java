package jvm.OverrideAndOverload;

/**
 * @Author yuchunwei
 */
public class OverLoad {
    private static void say(int i){
        System.out.println("int ");
    }
    private static void say(char i){
        System.out.println("char ");
    }
    private static void say(long i){
        System.out.println("long ");
    }
    private static void say(double i){
        System.out.println("double ");
    }
    private static void say(float i){
        System.out.println("float ");
    }


    public static void main(String[] args) {
        OverLoad.say(10);
    }
}   
