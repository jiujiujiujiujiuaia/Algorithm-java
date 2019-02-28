package algorithm.leetcode;

/**
 * @Author yuchunwei
 * not in algorithm.leetcode 判断一个数是不是2 的幂 如果是得是多少位
 */
public class Power2 {

    public static boolean isLog2(int a){
        return (a & a - 1) == 0 ;
    }
    public static int log2(int a){
        if (a == 1) return 0;
        else return 1+log2(a>>1);
    }



    public static void main(String[] args) {
       if( Power2.isLog2(1024)){
           System.out.println(Power2.log2(1024));
       }
    }
}   
