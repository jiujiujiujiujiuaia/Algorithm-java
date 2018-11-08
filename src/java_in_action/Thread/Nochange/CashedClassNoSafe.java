package java_in_action.Thread.Nochange;

public class CashedClassNoSafe implements Runnable{
    private String cashedStr = "a";
    private int cashedHashCode=1;

    public int action(String str) {
        // 如果str是cashedStr, 就直接返回缓存的hashCode值
        if (str.equals(cashedStr)) {
            return cashedHashCode;
        } else {
            // 将cashedStr和hashCode值缓存起来
            cashedStr = str;
            cashedHashCode = cashedStr.hashCode();
//            System.out.println("更新:"+cashedHashCode);
            return cashedHashCode;
        }
    }

    public void run(){
        if(Thread.currentThread().getName().equals("1")){
            System.out.println(action("a"));
        }
        else if(Thread.currentThread().getName().equals("2")) {
            System.out.println(action("b"));
        }
    }

    public static void main(String[] args){
        CashedClassNoSafe cashedClass = new CashedClassNoSafe();
       new Thread(cashedClass,"1").start();
       new Thread(cashedClass,"2").start();
       while (Thread.activeCount()>2){
           System.out.println("最后一个缓存"+cashedClass.cashedStr);
       }

    }
}