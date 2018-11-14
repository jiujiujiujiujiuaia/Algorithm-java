package java_in_action.Thread;

public class ResponseUi extends Thread {
    private static volatile double d = 1;
    public ResponseUi(){
        setDaemon(true);
    }
    public void run(){
        while (true){
            d = d+(Math.PI+Math.E)/d;
        }
    }

    public static void main(String[] args) throws Exception{
        new ResponseUi().start();
        System.in.read();
        System.out.println(d);
    }
}
