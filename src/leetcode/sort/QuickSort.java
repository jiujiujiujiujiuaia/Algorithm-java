package leetcode.sort;

import java.util.Arrays;

/**
 * @Author yuchunwei
 * 普通快排序
 */
public class QuickSort {

    public void quickSort(int[] nums ,int l , int r){
        if(l >= r )return ;
        int j = adjArray(nums,l,r);
        quickSort(nums,l,j-1);
        quickSort(nums,j+1,r);
    }
    private int adjArray(int[] nums,int l ,int r){
        //定义基准
        int temp = nums[l];
        //[l+1 , j] 小于 temp ,[j + 1 ,i] 大于 temp
        int j = l ;//j = l 就让两个区间都是失去了意义 这样就算是初始化了
        for(int i = l + 1 ; i <= r ; i++){
            if(nums[i] < temp) {
                int x = nums[i] ;
                nums[i] = nums[j+1] ;
                nums[j+1] = x ;
                j++;
            }
        }
        //j的位置就是基准数实际的位置
        int a = nums[j] ;
        nums[j] = nums[l];
        nums[l] = a ;
        return j ;
    }

    public static void main(String[] args) {
        int length = 10;
        int[] nums = new int[length];
        for(int i = 0 ; i < length ;i++){
            nums[i] = (int)(Math.random()*100)+1;
        }
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(nums,0,length-1);
        System.out.println(Arrays.toString(nums));


    }
}   
