package leetcode.array;

/**
 * @Author yuchunwei
 */
public class RemoveDuplicatesfromSortedArrayII {
    //wrong 不知道如何改进 不知道这类题目有一个什么思路
    public int removeDuplicates(int[] nums) {
        int k = 2;
        for(int i = 2 ; i < nums.length ; i++){
            if(nums[i] !=nums[k]){
                nums[k++] = nums[i] ;
            }
        }
        return k+1;
    }
    //right discuss上思路基本竟然和我是一样的，可以完美ac
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }


    public static void main(String[] args) {

    }
}   
