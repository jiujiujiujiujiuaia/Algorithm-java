package java_in_action.interfaces;

import java_in_action.interfaces.abstracts.Parent;

public interface Interface1  {
    Object process(Object input);
}


abstract class Process implements Interface1{
    protected int a ;
    public String process(Object input){
        return "";
    }
}

 class B extends Process{

}
