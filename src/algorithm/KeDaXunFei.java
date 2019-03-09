package algorithm;


import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yuchunwei
 * 科大讯飞编程题 有两个集合 分别告诉你两个集合的大小 例如 n m 然后输入n + m 个数（小于5大于0 ） 然后有一个计算value的公式
 * 集合A中的所有数字和除以集合A的大小，集合B中的所有数字除以集合B的大小 加起来最大 然后输出你分配的结果
 * 最难的地方就是如果有多个结果以字典序最小为准
 */
public class KeDaXunFei {
    private static int[] arr ;

    private static void solve(int[] index,int sizeA,int sizeB){
        int  min = sizeA > sizeB ? sizeB : sizeA ;
        int[] minsize = new int[6] ; //较小的集合存储
        int[] maxsize = new int[6] ; //较大的集合春初

        for(int i = 5 ; i > 0 ;i--){
            if(index[i] < min ){
                minsize[i] = index[i];
                min -= index[i] ;
                maxsize[i] = 0 ;
            }
            else {
                minsize[i] = min;
                maxsize[i] = index[i] - min ;
                min = 0;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        if(sizeA > sizeB) {
            for(int a = 0 ; a < sizeA + sizeB ; a++){
                if(maxsize[arr[a]] > 0) {
                    stringBuffer.append("1 ");
                    maxsize[arr[a]]--;
                }
                else {
                    minsize[arr[a]] -- ;
                    stringBuffer.append("2 ");
                }
            }
        }
        else {
            for(int a = 0 ; a < sizeA + sizeB ; a++){
                if(minsize[arr[a]] != 0) {
                    stringBuffer.append("1 ");
                    minsize[arr[a]]--;
                }
                else {
                    maxsize[arr[a]] -- ;
                    stringBuffer.append("2 ");
                }
            }
        }
        System.out.println(stringBuffer.toString());
    }



    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] index = new int[6];
         arr = new int[100000];
        int n = 0 ,sizeA = 0,sizeB = 0;
        if(input.hasNext()){
             n = input.nextInt();
             sizeA = input.nextInt();
             sizeB = input.nextInt();
        }

       for(int i = 0; i < n ;  ){
            int a = input.nextInt() ;
            arr[i++] = a;
           index[a]++;
        }
        solve(index , sizeA ,sizeB );
    }
}   
