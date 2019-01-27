package concurrency.SafePublish;

/**
 * @Author yuchunwei
 * 在懒汉模式下我们可以使用sycronized锁住get方法，但是这样效率太低（同步锁阻塞模型）
 * 注：如果单例不用volatile修饰的话，看上去线程安全的双重锁机制其实会由于指令重排导致内存逸出
 */
public class DoubleCheckLazySingleton {
    private volatile static DoubleCheckLazySingleton INSTANCE = null;
    private DoubleCheckLazySingleton(){

    }
    public static DoubleCheckLazySingleton getINSTANCE(){
        if(INSTANCE == null){
            synchronized (DoubleCheckLazySingleton.class){
                if(INSTANCE == null){
                    return new DoubleCheckLazySingleton();
                }
            }
        }
        return INSTANCE;
    }

}   
