package jvm;

/**
 * @Author yuchunwei
 */
public class AboutString {

    public static void main(String[] args) {
        String a ="abc2";

        final String b = "abc";
        String c = "abc";
        System.out.println(a==(b+2));
        System.out.println(a==(c+"2"));

    }
}   
