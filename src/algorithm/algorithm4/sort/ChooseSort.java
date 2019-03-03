package algorithm.algorithm4.sort;

/**
 * @Author yuchunwei
 * 选择排序 数组[0,1,2..n] 遍历到了i 保证[0,i]是有序的
 * 选择排序无论什么样的数组情况 （逆序或者顺序） 比较次数都是n(n-1)/2
 */
public class ChooseSort implements SortInterface{
    @Override
    public void sort(int[] arr) {

        for(int j = 0 ; j < arr.length ;j++){
            int p1 = j ;//遍历到第j号元素时
            for(int i = j ; i < arr.length ; i++ ){
                if(arr[p1] > arr[i]){
                    p1 = i;
                }
            }
            if(p1 != j){
                int temp = arr[p1];
                arr[p1] = arr[j];
                arr[j] = temp;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        TestSort.test(ChooseSort.class);
    }
}
