package algorithm.leetcode.array;

/**
 * @Author yuchunwei
 * algorithm.leetcode 27 只有两种情况需要k++ 一种是不为val 一种是交换
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0 ;i<nums.length ;i++){
            if(nums[i] !=val){
                if(k == i){
                    k++;
                }
                else {
                    nums[k] = nums[i] ;
                    k++;
                }
            }

        }
        return k;
    }
    //这个方法简洁一些了，就是增加了很多交换次数，[0,k]内不包含val
    public int removeElement2(int[] nums, int val) {
        int k = 0;
        for(int i = 0 ;i<nums.length ;i++){
            if(nums[i] !=val){
                nums[k] = nums[i] ;
                k++;
            }

        }
        return k;
    }

    public static void main(String[] args) {

    }
}   
