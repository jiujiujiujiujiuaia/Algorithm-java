package java_in_action.Thread;

public class VolatileUsage implements Runnable{
    public volatile int i;
    public void run(){
        try {
           i++;
            System.out.println(Thread.currentThread().getName() + "修改完了变量:" + i);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        VolatileUsage volatileUsage = new VolatileUsage();
            for (int i = 0; i < 2; i++) {
                new Thread(volatileUsage).start();
            }
    }

}
