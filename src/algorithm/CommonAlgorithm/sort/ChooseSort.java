package algorithm.CommonAlgorithm.sort;

/**
 * @Author yuchunwei
 * 选择排序 数组[0,1,2..n] 遍历到了i 保证[0,i]是有序的
 */
public class ChooseSort implements SortInterface{
    @Override
    public void sort(int[] arr) {

        for(int j = 0 ; j < arr.length ;j++){
            int p1 = j ;
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
