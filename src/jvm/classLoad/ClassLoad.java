package jvm.classLoad;

public class ClassLoad {
    public static int a = 1;
    public static final  int b = 2;

    static{
        System.out.println("静态代码块被调用");
    }
    public ClassLoad(){
        System.out.println("实例初始化");
    }
    public static void doAction(){
        System.out.println("调用静态");
    }
    public static void main(String[] args){
//      int a;
//      a = ClassLoad.a;
//      a = ClassLoad.b;

    }
}
