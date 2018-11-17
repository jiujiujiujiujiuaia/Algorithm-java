package java_in_action.Thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class IntGenerator {
    private volatile boolean cancel = false;
    public abstract int next();
    public void cancle(){
        cancel = true;
    }
    public boolean isCancle(){
        return cancel;
    }

    public static void main(String[] args){
        Checker.test(new EvenGenerator(),2);
    }
}

class EvenGenerator extends IntGenerator{
    private int value= 0;
    public synchronized int next(){
        value++;
        Thread.yield();
        value++;
        return value;
    }
}

class Checker implements Runnable{
    private IntGenerator generator;
    private final int id;
    public Checker(IntGenerator generator,int id){
        this.generator = generator;
        this.id = id;
    }

    public void run(){
        while (!generator.isCancle()){
            int val = generator.next();
            while (val%2 !=0){
                System.out.println(generator.isCancle()+" not even"+" id is :"+id);
                generator.cancle();
            }
        }
    }
    public static void test(IntGenerator gp,int count){
        System.out.println("start:");
        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i = 0 ;i < count ;i++){
            executorService.execute(new Checker(gp,i));
        }
        executorService.shutdown();
    }
}