package leetcode.array;

/**
 * @Author yuchunwei
 * leetcode 26
 */
public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        int k = 0;
        //如果有重复值，k指在重复值的第一个序列上
        for( int i = 0 ; i < nums.length;i++){
            if(nums[k] !=nums[i]) {
                nums[++k] = nums[i] ;
            }
        }
        return k + 1;
    }
    public static void main(String[] args) {

    }
}   
