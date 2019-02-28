package algorithm.CommonAlgorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yuchunwei
 * 桶排序
 * 简述一下思路：把元素根据最大值与最小值之差除以数组长度分为几个桶例如[10,11,20,21,30]这个数组就会被
 * 分为4个桶 10-15 15-20 20-25 25-30 然后再把数组分别类的放进相对应的桶中，然后对每个桶再一次排序
 *
 * 同时，当数据值范围固定且小，比如排序乱序1-10的数组，直接省去建立桶的步骤，直接立10个桶，数字几就是几号桶，记录其频率
 * 对于leetcode 451 同样的道理，一个char一般在一个字符出现的频次小于10，那么直接把频次当作桶号，桶中存char，遍历桶就可以从小
 * 往大排列了
 */
public class BucketSort implements SortInterface{

    private int indexFor(int a, int min, int step) {
        return (a - min) / step;
    }

    public void sort(int[] arr) {

        int max = arr[0], min = arr[0];
        for (int a : arr) {
            if (max < a)
                max = a;
            if (min > a)
                min = a;
        }
        //
        int bucketNum = max / 10 - min / 10 + 1;
        List buckList = new ArrayList<List<Integer>>();
        // create bucket
        for (int i = 1; i <= bucketNum; i++) {
            buckList.add(new ArrayList<Integer>());
        }
        // push into the bucket
        for (int i = 0; i < arr.length; i++) {
            int index = indexFor(arr[i], min, 10);
            ((ArrayList<Integer>) buckList.get(index)).add(arr[i]);
        }
        ArrayList<Integer> bucket = null;
        int index = 0;
        for (int i = 0; i < bucketNum; i++) {
            bucket = (ArrayList<Integer>) buckList.get(i);
            insertSort(bucket);
            for (int k : bucket) {
                arr[index++] = k;
            }
        }

    }

    // 把桶內元素插入排序
    private void insertSort(List<Integer> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            int temp = bucket.get(i);
            int j = i - 1;
            for (; j >= 0 && bucket.get(j) > temp; j--) {
                bucket.set(j + 1, bucket.get(j));
            }
            bucket.set(j + 1, temp);
        }
    }

    public static void main(String[] args) {
        BucketSort sort = new BucketSort();
        sort.sort(new int[]{1,3,6,7,3,8,2,9});
    }
}   
