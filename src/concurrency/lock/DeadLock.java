package concurrency.lock;

/**
 * @Author yuchunwei
 * //手写一段死锁
 */
public class DeadLock {

    private static String A = "A";
    private static String B = "B";


    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    System.out.println("enter A");
                    try {
                        Thread.sleep(2000);
                        synchronized (B){
                            System.out.println("dead lock ?");
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    System.out.println("enter B");
                    synchronized (A){
                        System.out.println("dead lock ?");
                    }
                }
            }
        }).start();
    }
}   
