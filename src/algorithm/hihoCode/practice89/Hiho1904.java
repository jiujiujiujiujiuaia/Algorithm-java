package algorithm.hihoCode.practice89;

import java.util.Scanner;

/**
 * @Author yuchunwei
 * 都8102年了
 */
public class Hiho1904 {

    public static int cal(int start,int end){
        int i = start;
        int count = 0;
        while (i<=end){
            int a = 1000;
            int b = 1;
            int temp = 0;
            int temp1 = i;
            while (a>=1){
                int num = temp1/a;
                temp+=num*b ;
                temp1-=num*a;
                a/=10;
                b*=10;
            }
            System.out.println("正确"+i);
            System.out.println("倒过来"+temp);
            if(temp - i >= 1000){
                count++;
            }
            i++;
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(cal(a,b));
        }
        in.close();
    }
}   
