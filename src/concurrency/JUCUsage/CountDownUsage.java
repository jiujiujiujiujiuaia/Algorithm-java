package concurrency.JUCUsage;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author yuchunwei
 * 这里通过CountDownLatch这个并发工具,实现了按照我们的思路控制整个流程
 * 简单介绍几个方法
 * await()凡是调用了这个方法的线程都会被阻塞，直到被调用对象初始化数字减到0，
 * 同时await方法也可以指定规定时间内阻塞，如果规定时间内没有完成任务，阻塞就关闭
 * countDown()被调用对象减1
 * 值得注意的是，这里需要Thread.sleep一下，因为好像main线程总是比非Main线程要先执行完，不记得为什么了
 */
public class CountDownUsage {

    private static CountDownLatch start = new CountDownLatch(1);

    private static CountDownLatch end = new CountDownLatch(6);

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(6);
        for(int i = 1 ; i <= 6 ; i ++) {
            executorService.execute(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "选手准备就绪等待裁判哨响");
                    start.await();
                    System.out.println(Thread.currentThread().getName() + "选手正在冲刺");

                    System.out.println(Thread.currentThread().getName() + "抵达终点");
                    end.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(1000);
        System.out.println("裁判哨响");
        start.countDown();
        end.await();
        System.out.println("比赛结束");
        executorService.shutdown();
        }
}   
