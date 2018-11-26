package java_in_action.interfaces.adpater;
//使用接口得函数是不变得，在这里就像是你去日本的酒店的插座是不变的，唯一的可以变得是你自己的插头
//然后去适应“插座”
public class Adapter implements JapanInterface{//实现了目标接口
    private ChinaInterface chinaInterface;//被适配的接口（这里使用的是代理）
    public Adapter(ChinaInterface chinaInterface){
        this.chinaInterface = chinaInterface;
    }

    public void voltage(){
        chinaInterface.voltage();
    }
}
