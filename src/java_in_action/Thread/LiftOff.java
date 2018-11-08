package java_in_action.Thread;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LiftOff implements Runnable{
    private int countDown = 10;
    private static int taskDown = 0;
    private final int id = taskDown++;

    private String status(){
        return countDown>0 ? id+"("+countDown+")":"#"+id+"liftoff";
    }
    public void run(){
        while (countDown-->0){
            System.out.println(status());
            Thread.yield();
        }
    }
    public static void main(String[] args){
        for(int i = 0;i<5;i++){
            Thread thread = new Thread(new LiftOff());
            thread.start();
        }
    }
}
