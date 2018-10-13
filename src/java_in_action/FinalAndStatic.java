package java_in_action;

class Value{
    int a;
    public Value(int i){
        this.a = i;
    }
}

public class FinalAndStatic {
    private static final Value B = new Value(2);
    private final int g ;
    private final Value a = new Value(1);
    private static int q = 3;
    private int s = 5;
    private static final int[] b = {1,2,3};

    public FinalAndStatic(){
        g = 1;
    }


    public static void doA(){

    }
//

    public static void main(String[] args){
       String a ="abc2";
       final String b = "abc";
       String c = "abc";
        System.out.println(a==(b+2));
        System.out.println(a==(c+2));

    }
}
