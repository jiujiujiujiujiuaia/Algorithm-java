package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 在1到n的范围 1出现的次数(未解)
 */
public class Code29 {

//    public int NumberOf1Between1AndN_Solution(int n) {
//
//    }
    public static void main(String[] args) {
        int n = 1999;
        int cnt = 0;
        for(int i = 1 ; i <= n ;i++){
            int num = i;
            while(num > 0){
                if(num % 10 == 1) cnt++;
                num /= 10;
            }

        }
        System.out.println(cnt);
    }
}   
