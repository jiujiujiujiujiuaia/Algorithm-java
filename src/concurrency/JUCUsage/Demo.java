package concurrency.JUCUsage;

import java.util.concurrent.CountDownLatch;

/**
 * @Author yuchunwei
 */
public class Demo {

    private static CountDownLatch end = new CountDownLatch(3);

    public static void main(String[] args) throws Exception{
        int i = 3;
        while (i-- > 0) {
            new Thread(new Runnable()  {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("第一组线程中的:" + Thread.currentThread().getName() + "抵达闭锁");
                        end.countDown();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        System.out.println("开始");
       end.await();
        System.out.println("第二组中的一个或者多个线程开始工作了");
    }
}   
