package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 超过数组大小一半的数
 */
public class Code24 {

    //存在输出值，不存在输出0
    public static int MoreThanHalfNum_Solution(int [] array) {
        if(array.length ==0){
            return 0;
        }
            int res = array[0];
            int time = 1;
            for(int i = 0 ; i < array.length ;i++){
                if(time == 0){
                    time = 1;
                    res = array[i];
                }
                else if(res == array[i]){
                    time++;
                }
                else {
                    time--;
                }
            }
            //如果这道题无解的话，最后一个res也不是频率超过一半的那个数字，所以要验证一下
            time = 0;
            for(int i = 0 ; i < array.length ; i++){
                if(res == array[i]){
                    time++;
                }
            }
            if(time > array.length / 2){
            return res;
        }
        else return 0;
    }

    public static void main(String[] args) {
            int[] a = {1,4,2,4,3,4,5,4,4};
            int[] b = {1,2,3,4,5,6};
            int[] c = {1,1,1,1};
            int[] d = {1,1,1,1,2,2};
        System.out.println(MoreThanHalfNum_Solution(a));
        System.out.println(MoreThanHalfNum_Solution(b));
        System.out.println(MoreThanHalfNum_Solution(c));
        System.out.println(MoreThanHalfNum_Solution(d));

    }
}   
