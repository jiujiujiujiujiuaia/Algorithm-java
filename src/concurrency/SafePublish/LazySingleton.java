package concurrency.SafePublish;

/**
 * @Author yuchunwei
 * 线程不安全，有可能会出现两次构造器初始化
 */
public class LazySingleton {

    private static LazySingleton lazySingleton = null;
    private LazySingleton(){
        //私有构造函数
    }
    public static LazySingleton getLazySingleton(){
        if(lazySingleton == null){
            return new LazySingleton();
        }
        return lazySingleton;
    }
}   
