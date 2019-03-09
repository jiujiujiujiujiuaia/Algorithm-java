package algorithm.algorithm4.sort;

import java.util.Random;

/**
 * @Author yuchunwei
 * 优点：
 * 处理重复数字
 * 同时没有重复数字的情况下效果也不错
 */
public class Quick3WaySort implements SortInterface{

    @Override
    public void sort(int[] arr) {
        sort(arr,0,arr.length - 1);
    }

    private void sort(int[] nums,int l,int r) {
        if(l>r) return ;

        int lt = l;//[l+1,lt] <v
        int gt = r + 1; //[gt,r] >v
        int i = l + 1; //[lt+1,i) == v
//        Random random = new Random();
//        int index = l + random.nextInt() % (r - l + 1);
//        TestSort.exchage(nums, index, l);
        int temp = nums[l];
        while (i < gt) {
            if (nums[i] < temp) {
                TestSort.exchage(nums, i, lt + 1);
                lt++;
                i++;
            } else if (nums[i] > temp) {
                TestSort.exchage(nums, i, gt - 1);
                //不需要动指针i
                gt--;
            } else {
                i++;
            }
        }
        TestSort.exchage(nums,l,lt);
        sort(nums,l,lt-1 );
        sort(nums,gt,r);
    }

    public static void main(String[] args) throws Exception{
        TestSort.test(Quick3WaySort.class);
    }


}
