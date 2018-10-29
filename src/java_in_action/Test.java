package java_in_action;

import java.util.Arrays;
import java.util.List;

public class Test extends MyClass {

    private final void a(){
        System.out.println("it is Parent");
    }

    public static void main(String[] args)  {
        Test test = new Test();
        test.a();
        List<Integer> list = Arrays.asList(1,2,3);
        System.out.println(list);
    }
}

class MyClass {
    private final void a(){
        System.out.println("it is MyTest");
    }
}
