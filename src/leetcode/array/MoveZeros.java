package leetcode.array;

/**
 * @Author yuchunwei
 * leetcode 283
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        //solution1
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0) {
                for(int j = i+1 ; j < nums.length; j++){
                    if(nums[j] != 0 ){
                        int a = nums[i] ;
                        nums[i] = nums[j];
                        nums[j] = a;
                        break;
                    }
                }
            }
        }

    }
    //只找非零元素，一个指针k从0开始标记，然后再补上后面的零值
    public void moveZeroes2(int[] nums) {
        int k = 0 ;
        for(int i = 0 ; i< nums.length ; i++){
            if(nums[i] != 0) nums[k++] = nums[i];
        }
        for(;k<nums.length;k++){
            nums[k] = 0;
        }
    }
    //只找非零元素，[0,k)都是非零元素,无须再补零
    public void moveZeroes3(int[] nums){
        for(int i = 0, k = 0;i<nums.length;i++){
            if(nums[i] != 0) {
                if(i == k) {
                    k++;
                }
                else {
                    nums[k++] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,0,1};
        MoveZeros moveZeros = new MoveZeros();
        moveZeros.moveZeroes3(nums);
    }
}   
