package algorithm.newcoder.offer;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;

/**
 * @Author yuchunwei
 *最小K个数
 */
public class Code26 {
    private int[] pq ;
    private int tail = 0;

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList arrayList = new ArrayList();
        //和面试官好好沟通  k的情况 以及返回什么
        if(k > input.length || k == 0) return arrayList;
        pq = new int[k+1];
        for(int a : input){
            insert(a);
        }
        return getPQ();
    }

    public ArrayList<Integer> getPQ(){
         ArrayList<Integer> res = new ArrayList<>();
         for(int a : pq){
             res.add(a);
         }
         res.remove(0);
         return res;
    }

    private void insert(int key){
        if(tail < pq.length - 1){
            pq[++tail] = key;
            swim(tail);
        }
        else if(key < pq[1]){
            pq[1]  = key;
            sink(1);
        }
    }

    private void swim(int index){
        while (index > 1){
            if(less(index/2,index))exch(index/2,index);
            index = index/2;
        }
    }
    private void sink(int index){
        //提前判断以免超出界
        while (index*2 <= tail){
            int j = index * 2;
            if(j < tail && less(j,j+1)) j++;
            if(less(j,index)) break;
            exch(j,index);
            index = j;
        }
    }
    private boolean less(int i ,int j){
        return pq[i]<pq[j];
    }
    private void exch(int i , int j ){
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8};
        int k = 10;
        Code26 code26 = new Code26();
        code26.GetLeastNumbers_Solution(a,k);
    }
}   
