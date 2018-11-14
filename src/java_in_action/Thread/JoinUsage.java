package java_in_action.Thread;

//join方法变相的使得线程串行执行，如果在线程A中调用线程B方法，知道线程B执行完了才执行A,但是join方法必须等start方法执行了才能join
//yeild方法如其翻译一样，愿意从执行状态变成就绪状态，但是jvm不一定放权交给其他的线程。
//sleep是当前线程堵塞，把时间权交给其他线程
public class JoinUsage extends Thread{
    private int i = 5;

    public void run(){
        try {
            System.out.println("睡觉啊");
//           Thread.yield();
            while (i > 0) {
                i--;
                System.out.println(i);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try {
            JoinUsage joinUsage = new JoinUsage();
            joinUsage.start();
//            joinUsage.join();
            System.out.println("开始：");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
