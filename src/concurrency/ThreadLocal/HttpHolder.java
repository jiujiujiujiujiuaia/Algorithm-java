package concurrency.ThreadLocal;

/**
 * @Author yuchunwei
 * 这里模拟的是请求已经进入到后台filter中，但是还有没有接受Controller等等处理，把常用的对象封闭在threadLocal中，这样就可以随时
 * 取到，随时获得。
 */
public class HttpHolder {
    private final static ThreadLocal<Long> holder = new ThreadLocal<>();

    public static void add(Long id){
        holder.set(id);
    }

    public static Long getId() {
        return holder.get();
    }

    public static void remove() {
        holder.remove();
    }
}   
