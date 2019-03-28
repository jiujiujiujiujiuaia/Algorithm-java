package concurrency.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author yuchunwei
 */

class SubThread implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            //do nothing
        }
    }
}
public class ThreadPoolUsage {

    private static ExecutorService executor = Executors.newFixedThreadPool(15);
    public static void main(String[] args) {
        //模拟内存溢出
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executor.execute(new SubThread());
        }
    }
}


