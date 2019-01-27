package concurrency.SafePublish;

/**
 * @Author yuchunwei
 */
public class EnumSingleton {
    private EnumSingleton(){

    }
    /*
    优势
    1 enum有且仅有private的构造器
    2 序列化和反序列化，因为每一个枚举类型和枚举变量在JVM中都是唯一的，即Java在序列化和反序列化枚举时做了特殊的规定，枚举的
    writeObject、readObject、readObjectNoData、writeReplace和readResolve等方法是被编译器禁用的
    3 线程安全
     */
    private static EnumSingleton getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
    private enum Singleton {
        INSTANCE;

        private EnumSingleton singleton;

        // JVM保证这个方法绝对只调用一次.因为是private
        Singleton() {
            singleton = new EnumSingleton();
        }

        public EnumSingleton getInstance() {
            return singleton;
        }
    }
}   
