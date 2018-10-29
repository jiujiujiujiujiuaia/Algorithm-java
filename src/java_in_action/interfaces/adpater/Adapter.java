package java_in_action.interfaces.adpater;

public class Adapter implements JapanInterface{//实现了目标接口
    private ChinaInterface chinaInterface;//被适配的接口（这里使用的是代理）
    public Adapter(ChinaInterface chinaInterface){
        this.chinaInterface = chinaInterface;
    }

    public void voltage(){
        chinaInterface.voltage();
    }
}
