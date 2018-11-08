package java_in_action.Thread.Nochange;

class OneCashedValue {
    // 成员变量都是final的
    private final String str;
    private final int strHashCode;

    // 构造过程中不会发生this逃逸
    public OneCashedValue(String str, int strHashCode) {
        this.str = str;
        this.strHashCode = strHashCode;
    }

    public int getStrHashCode(String str) {
        if (!this.str.equals(str)) {
            // -1表示无效的hashCode值
            return -1;
        }
        return strHashCode;
    }
}


public class CashedClass implements Runnable{
    private volatile OneCashedValue oneValue = new OneCashedValue("a", 1);

    public int action(String str) {
        int hashCode = oneValue.getStrHashCode(str);
        if (hashCode == -1) {
            hashCode = str.hashCode();
            // 对volatile变量的修改不依赖于当前值, 符合volatile的使用场景
            oneValue = new OneCashedValue(str, hashCode);
        }
        return hashCode;
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
        CashedClass cashedClass = new CashedClass();
        new Thread(cashedClass,"1").start();
        new Thread(cashedClass,"2").start();
    }
}