package algorithm.algorithm4.sort;

/**
 * @Author yuchunwei
 */
public class HeapSort implements SortInterface {

    @Override
    public void sort(int[] arr) {
        Heap maxHeap = new Heap(arr.length);
        for(int a : arr){
            maxHeap.insert(a);
        }
        for(int i = arr.length - 1 ; i >= 0 ; i--){
            arr[i] = maxHeap.deleMax();
        }
    }

    public static void main(String[] args) throws Exception{
        TestSort.test(HeapSort.class);
    }
}
