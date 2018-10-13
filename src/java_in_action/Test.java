package java_in_action;

public class Test extends MyClass {

    private final void a(){
        System.out.println("it is Test");
    }

    public static void main(String[] args)  {
        Test test = new Test();
        test.a();
    }
}

class MyClass {
    private final void a(){
        System.out.println("it is MyTest");
    }
}
