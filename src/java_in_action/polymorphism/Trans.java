package java_in_action.polymorphism;

class Actor{
    public void act(){
    }
}

class HapActor extends Actor{
    public void act(){
        System.out.println("happy");
    }
}

class SadActor extends Actor{
    public void act(){
        System.out.println("sad");
    }
    public void doAct(){
        System.out.println("sad act");
    }
}

public class Trans {
    private Actor actor = new HapActor();
    public void change(){
        actor = new SadActor();
    }
    public void doAction(){
        actor.act();
    }
    public static void main(String[] args){
        Actor[] actors = {new Actor(),new SadActor()};
        actors[0].act();
        actors[1].act();
        ((SadActor)actors[1]).doAct();
    }
}
