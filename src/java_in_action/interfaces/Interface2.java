package java_in_action.interfaces;

public class Interface2 {
    public Object process(Object input){
        return "i am a dad";
    }

    public static void main(String[] args){
        Interface2 a = new Processer();
        System.out.println(a.process(""));
    }
}

class Processer extends Interface2{
    public String process(String input){
        return "i am son";
    }
}
