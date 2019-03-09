package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 节省空间的斐波那契
 */
public class Code10 {

    public int Fibonacci(int n) {

        int[] res = {0,1};
        if(n <= 1) return res[n];
        int pre = 1;
        int lastPre = 0 ;
        int temp = 0;
        for(int i = 2 ; i <= n ;i++){
            temp = pre + lastPre;
            lastPre = pre;
            pre = temp;
        }
        return temp;
    }

}
