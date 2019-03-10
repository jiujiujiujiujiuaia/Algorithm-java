package concurrency.JUCLock;

/**
 * @Author yuchunwei
 */
public class TwinsLockTest extends Thread {
    private final TwinsLock lock= new TwinsLock();

    @Override
    public void run() {

            lock.lock();
            try{

                System.out.println(Thread.currentThread().getName() + "执行");
                Thread.sleep(10000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                lock.unlock();
            }

    }

    public static void main(String[] args) throws Exception{
        for(int i = 0 ; i < 10 ; i++){
            TwinsLockTest test = new TwinsLockTest();
            test.start();
        }
        System.out.println("start:");
    }
}   
