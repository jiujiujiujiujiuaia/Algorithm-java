package algorithm.newcoder.offer;

import algorithm.algorithm4.sort.TestSort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yuchunwei
 * 数组中重复的数字
 */
public class Code6 {


    //是否有重复的数字，如果有放在duplication第一个中
    //可以询问一下面试官 1如果numbers为空，那duplication中存储什么2可否修改
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        for(int i = 0 ; i < numbers.length - 1 ; i++){
            while(numbers[i] != i) {
                int index = numbers[i];
                if(index == numbers[index]) {
                    duplication[0] = index;
                    return true;
                }
                exchage(numbers, i, index);
            }
        }
        duplication[0] = -1;
        return false;
    }

    public void exchage(int[] arr ,int i , int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {

    }
}   
