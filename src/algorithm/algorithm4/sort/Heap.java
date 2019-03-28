package algorithm.algorithm4.sort;

/**
 * @Author yuchunwei
 * 最大堆，同时堆还有一个特点就是他只在乎最大的那个值，和最大的前多少个值，期间是没有顺序的
 * 堆一种二叉树的形式，保证每一个父节点大于左右节点，也就是父节点就是整个堆最大的
 * 插入和获取最大指 操作时间复杂度都是o（logN）
 */
public class Heap {
    private int[] pq;//二叉堆数组
    private int tail  = 0; //指向最后一个元素（方便插入）

    public Heap(int N){
        pq = new int[N+1]; //为了方便 数组长度为N+1 也就是0索引空出来
    }

    //第一个数是否小于第二个数
    private boolean less(int i , int j){
        return pq[i] < pq[j] ;
    }

    private void exch(int i ,int j ){
        int k = pq[i];pq[i] = pq[j];pq[j] = k ;
    }
    private void swim(int k ){
        //k已经为1了就没有意义，所以最大才1
        while (k > 1 && less(k/2,k)){
            exch(k,k/2);
            k = k/2;
        }
    }
    private void sink(int k){
        while (k * 2 <= tail){
            int j = k*2 ;
            //比较左右两个字节点，那个更大就和k比较
            if(j < tail && less(j,j+1))j++;
            if(less(j,k))break;
            exch(k,j);
            k = j;
        }
    }
    //插入的时候，放入队尾，上浮
    public void insert(int key){
        pq[++tail] = key;
        swim(tail);
    }

    //删除的时候，去掉对头，交换队尾，下沉
    public int deleMax(){
        int key = pq[1];
        exch(1,tail--);
        pq[tail+1] = 0;
        sink(1);
        return key;
    }


}   
