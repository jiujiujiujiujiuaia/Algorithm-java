package algorithm.algorithm4.sort;

import java_in_action.Test;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author yuchunwei
 * 优点 ;时间复杂度又小 [o(nlogn)]，空间消耗又少（原地排序）
 *
 * 缺点
 * 1 数据规模小 更推荐插入排序
 * 2 重复数据多,用三路快排
 * 3 最坏情况会退到o(n^2) 改进方法是应该随机选取标记点
 */
public class QuickSort implements SortInterface{

    public void sort(int[] arry){
        sort(arry,0,arry.length - 1);
    }

    public void sort(int[] nums ,int l , int r){
        //if(l >= r )return ;
        //优化 数据量小的时候，比如16个元素及一下时，使用插入排序
        if(r - l < 16){
            InsertSort sort = new InsertSort();
            sort.sort(nums);
            return ;
        }
        int j = partition(nums,l,r);
        sort(nums,l,j-1);
        sort(nums,j+1,r);
    }
    private int partition(int[] nums,int l ,int r){
        //定义基准
        //优化二  每次选取左边第一个数可能会有最坏情况 应该随机的选区
//        int temp = nums[l];
        Random random = new Random();
        int index = l + random.nextInt() % (r - l);
        TestSort.exchage(nums,index,l);
        int temp = nums[l];
        //[l+1 , j] 小于 temp ,[j + 1 ,i] 大于 temp
        int j = l ;//j = l 就让两个区间都是失去了意义 这样就算是初始化了
        for(int i = l + 1 ; i <= r ; i++){
            //每遇到一个小于temp的就替换j+1的位置，扩大j的指针
            if(nums[i] < temp) {
               TestSort.exchage(nums,i,j+1);
               j++;
            }
        }
        //j的位置就是基准数实际的位置
        TestSort.exchage(nums,l,j);
        return j ;
    }

//    private int threeRoadPartition(int nums,int l ,int r){
//
//    }

    public static void main(String[] args) throws Exception {
        TestSort.test(QuickSort.class);
    }
}   
