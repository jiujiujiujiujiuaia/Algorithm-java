package java_in_action.Thread;

public class AmazingCode {
    private static volatile boolean bChanged;
    private static   boolean ready;
    private  int count = 0;
    private static class ReaderThread extends Thread{
        public void run(){
            System.out.println("开始读");
            while (!ready) { System.out.println("进入线程");}
//            System.out.println(count);
        }
    }

    private static class WriterThread extends Thread{
        public void run(){;
            System.out.println("开始写");
            ready = true;

        }
    }

    private  class Action1 extends Thread{
        public void run(){
            System.out.println("开始读");
        }
    }

    private  class Action2 extends Thread{
        public void run(){
            int j = count;
            System.out.println("j is "+j);
        }
    }

    public static void main(String[] args) throws InterruptedException {
//       AmazingCode visible = new AmazingCode();
//       visible.new Action1().start();
//        visible.new Action2().start();
//        System.out.println("线程开始");
        new Thread() {

            @Override
            public void run() {
                for (;;) {
                    System.out.println("进入");
                    System.out.println(Thread.currentThread().getName()+bChanged);
                    if (bChanged == !bChanged) {
                        System.out.println("!=");
                        System.exit(0);
                    }
                    System.out.println(Thread.currentThread().getName()+bChanged);
                }
            }
        }.start();
        Thread.sleep(1);
        new Thread() {
            @Override
            public void run() {
                for (;;) {
                    bChanged = !bChanged;
                    System.out.println(Thread.currentThread().getName()+bChanged);
                }
            }
        }.start();
    }
}
