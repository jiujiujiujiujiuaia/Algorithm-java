package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 二维数组中的查找
 */
public class Code1 {
    /*
    1 首先这道题考察的二分查找，先回顾一下二分查找，如果查找的数在数组最大和最小值之间，
    那么返回mid就是比它大
    2 如果查找的数比数组最的值还大，或者比数组最小的值还小，那么mid返回的是数组上限和下限
    3 同时关于二分查找while判断中l < r 还是 l <= r 根据定义来，如果你定义的是
    [l,r]这样的区间话,如果l == r，区间[r,r]仍然成立
    3 这道题只能从右上或者左下开始寻找，因为左上和右下都会错误某些值
     */

    public static boolean Find(int target, int [][] array) {
        int N = array.length - 1;
        if(array[0].length == 0) return false ;
        int i = 0 , j = N;
        while (i <= N && j >= 0){
            if(target > array[i][j]){
                i++;
            }
            else if(target < array[i][j]){
                j--;
            }
            else return true;
        }
        return false;
    }

    public static int a(double k ,int[] arr){
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while (l <= r){
            mid = (r - l) /2 + l ;
            if(k > arr[mid]) l = mid + 1;
            else if (k < arr[mid]) r = mid - 1;
            else return mid;
        }
        return mid;
    }




    public static void main(String[] args) {
      int[] ar = {1,2,3,4,5};
      int[] br = {1,2,3,4};
        System.out.println(a(100,ar));
        System.out.println(a(100,br));
    }
}   
