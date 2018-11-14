package java_in_action.Thread.zhihu_Tutorial;

public class Goal implements Runnable{
    private boolean goal ;

    private boolean isGoal() {
        return goal;
    }

    public void setGoal(Boolean goal){
        this.goal = goal;
    }

    public void run(){
        while(true){
//            System.out.println("启动了");
            if(isGoal()){
                System.out.println("进球了");
                setGoal(false);
            }
        }
    }

    public static void main(String[] args){
        try {
            Goal goal = new Goal();
            new Thread(goal).start();
            Thread.sleep(3000);
            goal.setGoal(true);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
