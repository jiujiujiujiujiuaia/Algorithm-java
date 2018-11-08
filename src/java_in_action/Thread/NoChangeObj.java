package java_in_action.Thread;

import java.util.Arrays;

public class NoChangeObj {
    //这里证明了即使是final 也不能保证可见性
    private final Integer[] changeObj;
    private final Integer[] unChangeObj;

    public NoChangeObj(Integer[] args){
        changeObj = args;
        unChangeObj = Arrays.copyOf(args,args.length);
    }
    public void get(){
        System.out.println("change:");
        for(Integer a : changeObj){
            System.out.println(a);
        }
        System.out.println("unchange");
        for(Integer b : unChangeObj){
            System.out.println(b);
        }
    }

    public static void main(String[] args){
        Integer[] test = {1,2,3,4,5};
        NoChangeObj noChangeObj = new NoChangeObj(test);
        noChangeObj.get();
        test[3] = 100;
        noChangeObj.get();
    }
}
