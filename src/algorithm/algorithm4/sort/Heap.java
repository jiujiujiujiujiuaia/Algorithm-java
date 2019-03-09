package algorithm.algorithm4.sort;

/**
 * @Author yuchunwei
 * 堆
 */
public class Heap {
    private int[] pq;//二叉堆数组
    private int tail  = 0; //指向最后一个元素（方便插入）

    public Heap(int N){
        pq = new int[N+1];
    }

    private boolean less(int i , int j){
        return pq[i] < pq[j] ;
    }

    private void exch(int i ,int j ){
        int k = pq[i];pq[i] = pq[j];pq[j] = k ;
    }
    private void swim(int k ){
        while (k > 1 && less(k/2,k)){
            exch(k,k/2);
            k = k/2;
        }
    }
    private void sink(int k){
        while (k * 2 <= tail){
            int j = k*2 ;
            if(j < tail && less(j,j+1))j++;
            if(less(j,k))break;
            exch(k,j);
            k = j;
        }
    }

    public void insert(int key){
        pq[++tail] = key;
        swim(tail);
    }

    public int deleMax(){
        int key = pq[1];
        exch(1,tail--);
        pq[tail+1] = 0;
        sink(1);
        return key;
    }


}   
