package java_in_action.InnerClass;



public class OutClass {

    private static class StaticInnerClass{
        private void test(){
            System.out.println("hello,world");
        }
    }

    private class InnerClass{

    }

    public static void main(String[] args){
        OutClass outClass = new OutClass();
        OutClass.InnerClass innerClass = outClass.new InnerClass();
        OutClass.StaticInnerClass staticInnerClass = new OutClass.StaticInnerClass();
    }
}
