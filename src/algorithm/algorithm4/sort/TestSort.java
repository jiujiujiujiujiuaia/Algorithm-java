package algorithm.algorithm4.sort;

import java.util.Arrays;
import java.util.Random;


/**
 * @Author yuchunwei
 */
public class TestSort {

    public static void test(Class<?> clazz) throws Exception{
        SortInterface sort = (SortInterface) clazz.newInstance();
        Random random = new Random() ;
        int length = 10;
        int[] arr = new int[length];
        for(int i = 0 ; i < length ;i++){
            arr[i] = random.nextInt(100);
        }
        int[] temp = arr.clone();
        int[] res = arr.clone();
        Arrays.sort(temp);
        sort.sort(arr);
        for(int j = 0 ; j < 10 ; j++) {
            for (int i = 0; i < arr.length; i++) {
                if (temp[i] != arr[i]) {
                    System.out.println("出错了");
                    System.out.println("原本数组 ：" + tostring(res));
                    System.out.println("错误排序后 ：" + tostring(arr));
                    return;
                }
            }
        }
        System.out.println("完全正确");
    }

    public static void exchage(int[] arr ,int i , int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static String tostring(int[] arr){
        StringBuffer stringBuffer = new StringBuffer();
        for(int a : arr){
            stringBuffer.append(a+",");
        }
        return stringBuffer.toString();
    }
}   
