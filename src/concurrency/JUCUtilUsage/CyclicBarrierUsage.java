package concurrency.JUCUtilUsage;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author yuchunwei
 * CyclicBarrier 循环栅栏
 */
public class CyclicBarrierUsage {

    private static CyclicBarrier barrier = new CyclicBarrier(6,()  ->{
        System.out.println("裁判员一声令响，比赛开始！！！");
    });

    private static void judge(String message){
        System.out.println(message);
    }

    private static CyclicBarrier end = new CyclicBarrier(6,() -> {
        System.out.println("比赛结束！！！");
    });
    public static void main(String[] args)  {
        ExecutorService service = Executors.newFixedThreadPool(6);
        for(int i = 0 ; i < 6 ; i ++ ){
            service.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "选手准备就绪");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + "冲过终点");
                    end.await();

                }
                catch (Exception e){
                    e.printStackTrace();
                }

            });

        }

    }
}   
