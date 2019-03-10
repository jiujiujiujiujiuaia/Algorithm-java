package concurrency.JUCLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @Author yuchunwei
 */
public class TwinsLock implements Lock {

    private static final class Sync extends AbstractQueuedSynchronizer{

        Sync(int count){
            if(count <= 0) throw new IllegalArgumentException("参数不能为0");
            setState(count);
        }

        @Override
        protected int tryAcquireShared(int reduceCount) {
            for(;;){
                int cur  = getState();
                int newcount = cur - reduceCount;
                if(newcount < 0 || compareAndSetState(cur,newcount)){
                    return newcount;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            for(;;){
                int cur = getState();
                int newcount = cur + arg;
                if(compareAndSetState(cur,newcount)){
                    return true;
                }
            }
        }
    }

    private Sync sync = new Sync(2);
    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.releaseShared(1);
    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
