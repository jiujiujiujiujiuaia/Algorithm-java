package jvm.classLoad;

public class Apply {
    public static void main(String[] args){
        int a;
        a = ClassLoad.a;
//         a = ClassLoad.b;
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(Apply.class.getClassLoader());
    }
}
