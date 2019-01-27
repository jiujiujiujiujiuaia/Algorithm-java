package concurrency.SafePublish;

/**
 * @Author yuchunwei
 * 饿汉模式
 * 类在装载的时候就完成单例的初始化
 * 线程安全但是会导致类装载时间过久
 */
public class HugerySingleton {
    private HugerySingleton(){

    }

    private HugerySingleton hugerySingleton = new HugerySingleton();

    private HugerySingleton getHugerySingleton(){
        return hugerySingleton;
    }
}   
