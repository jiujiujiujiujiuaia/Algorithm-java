package algorithm.CommonAlgorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @Author yuchunwei
 * 冒泡排序
 */
public class BubbleSort implements SortInterface {

    public void sort(int[] arr){
        for(int n = arr.length ; n > 1 ;n-- )
        for(int i = 1 ; i < n ; i ++ ){
            if(arr[i-1] < arr[i]) continue;
            else {
                int temp = arr[i-1];
                arr[i-1]  = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        TestSort.test(BubbleSort.class);
    }
}   
