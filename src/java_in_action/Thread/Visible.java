package java_in_action.Thread;

public class Visible {
    private static volatile boolean ready;
    private static int count = 0;
    private static class ReaderThread extends Thread{
        public void run(){
            System.out.println("开始读");
            while (!ready) { System.out.println("进入线程");}
            ready = false;
        }
    }

    private static class WriterThread extends Thread{
        public void run(){
            System.out.println("开始写");
            ready = true;
        }
    }

    public static void main(String[] args){
        new ReaderThread().start();
        new WriterThread().start();
    }
}
