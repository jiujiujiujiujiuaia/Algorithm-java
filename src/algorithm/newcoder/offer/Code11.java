package algorithm.newcoder.offer;

/**
 * @Author yuchunwei
 * 旋转数组问题 不是最佳解
 */
public class Code11 {
    //思路就是旋转数组后就是变成了两个有序数组
    public static int minNumberInRotateArray(int [] array) {
        //这道题目的数据可能情况
        //1 顺序递增数组
        //2 旋转后的数组
        //3 mid l r 相等的情况
        int l = 0 ; //指向大数组的最小的
        int r = array.length - 1; //指向小数组最大的
        while (array[l] >= array[r]){ //注意一定要有等于号 对于[3,2,3,3,3]
            if(r - l == 1){
                return array[r];
            }

            int mid = (r + l) / 2;
            if(array[mid] == array[l] && array[mid] == array[r]) {
                System.out.println("使用顺序查找");
                break;
            }
            if(array[mid] >= array[l]){  //要加等于号，因为数字重复的情况也继续可以二分[5,5,5,1,2,3]
                l = mid;
            }
            else if(array[mid] <= array[r]){//同理
                r = mid;
            }
            //顺序查找
        }
        return array[l];
    }

    public static void main(String[] args) {
        int[] a  = {2,2,2,3,3,3};
        int[] b  = {4,5,6,1,2,3};
        int[] c  = {1,2,3,4,5};
        int[] d  = {1,2,3,4,5,6};
        System.out.println(minNumberInRotateArray(a));
        System.out.println(minNumberInRotateArray(b));
        System.out.println(minNumberInRotateArray(c));
        System.out.println(minNumberInRotateArray(d));

    }

}   
