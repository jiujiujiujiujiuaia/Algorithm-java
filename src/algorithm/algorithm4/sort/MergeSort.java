package algorithm.algorithm4.sort;

import edu.princeton.cs.algs4.Merge;
import java_in_action.Test;

/**
 * @Author yuchunwei
 * 归并排序
 * 首先先将数组分治，然后归并，最后得到左半边有序，右半边有序的，使用o(n)的算法归并，获得一个nlog(n)的算法
 */
public class MergeSort implements SortInterface{
    private int[] help ;
    @Override
    public void sort(int[] arr) {
        help = new int[arr.length];
        sort(arr,0,arr.length - 1);
    }

    public void sort(int[] arr,int l,int h ){

        //if(l >= h) return ;
        //优化二 在数据量的时候，比如16个元素及一下时，使用插入排序
        if(h - l < 16){
            InsertSort sort = new InsertSort();
            sort.sort(arr);
            return ;
        }
        int mid = l + (h - l) / 2;
        sort(arr,l,mid);
        sort(arr,mid+1,h);
        //优化一 左半区的最后一个值比右半区的第一个值小时，不需要归并
        //也就是说，如果数组近乎有序，那么可以不进行那么多次的merge
        if(arr[mid] > arr[mid +1]) merge(arr,l,mid,h);

    }

    //归并，开辟额外空间，mid指左半边和右半边的交界
    private void merge(int[] arr,int l,int mid,int h){
        int j = l; //指向左半区的第一个
        int i = mid + 1; //指向右半区的第一个
        for(int k = l ; k <= h ; k++){
            help[k] = arr[k]; //复制一份
        }

        for(int k = l ; k <=h ;k++){
            if(j > mid) arr[k] = help[i++]; //说明左半区复制完，直接全部复制右半区
            else if(i > h) arr[k] = help[j++] ; //说明右半区复制完，直接全部复制左半区
            else if(help[j] > help[i] ) arr[k] = help[i++];
            else arr[k] = help[j++];
        }
    }
    //自顶向下的分治，自底向上的归并


    public static void main(String[] args) throws Exception {
        TestSort.test(MergeSort.class);
    }
}   
