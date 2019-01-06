package leetcode.array;

/**
 * @Author yuchunwei
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

    public static void main(String[] args) {

    }
}   
