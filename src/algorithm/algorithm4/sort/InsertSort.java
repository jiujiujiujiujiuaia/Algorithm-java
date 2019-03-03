package algorithm.algorithm4.sort;

import java_in_action.Test;

/**
 * @Author yuchunwei
 * 1 插入排序最好的情况下（数组有序）只需要比较n-1次和0次交换
 * 2 最坏的情况（逆序）是n(n-1)/2 比较 和n(n-1)/2交换
 * 3 平均情况是n(n-1)/4 比较
 * 4 数组部分有序时，插入排序是不错的选择，当然也可以看出插入排序比选择排序快
 */
public class InsertSort implements SortInterface{
    @Override
    public void sort(int[] arr) {
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = i ; j > 0 && arr[j] < arr[j-1] ; j--){
                TestSort.exchage(arr,j,j-1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        TestSort.test(InsertSort.class);
    }
}
