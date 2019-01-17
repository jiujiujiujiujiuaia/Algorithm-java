package leetcode.array;

/**
 * @Author yuchunwei
 * leetcode
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
    //一开始得思路就是用遍历指针和遍历指针-2相比 这样会导致交换过后出现重复得问题
    //用k指针相比得话就不会出现那样的问题
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
