package leetcode.array;

/**
 * @Author yuchunwei
 * leetcode 215
 */
public class KthLargestElementinanArray {
    //利用块排得思路解出来得 复杂度在O(n)
    private int res;
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums,0,nums.length - 1 ,false,k);
        return res;
    }

    private void quickSort(int[] nums ,int l , int r,boolean flag,int k){
        if(l > r || flag)return ;
        int j = adjArray(nums,l,r);
        if(nums.length - j < k ) quickSort(nums,l,j-1,false,k);
        else if(nums.length - j > k ) quickSort(nums,j+1,r,false,k);
        else {
            res = nums[j];
            quickSort(nums,j+1,r,true,k);
        }

    }
    private int adjArray(int[] nums,int l ,int r){
        //定义基准
        int temp = nums[l];
        //[l+1 , j] 小于 temp ,[j + 1 ,i] 大于 temp
        int j = l ;//j = l 就让两个区间都是失去了意义 这样就算是初始化了
        for(int i = l + 1 ; i <= r ; i++){
            if(nums[i] < temp) {
                int x = nums[i] ;
                nums[i] = nums[j+1] ;
                nums[j+1] = x ;
                j++;
            }
        }
        //j的位置就是基准数实际的位置
        int a = nums[j] ;
        nums[j] = nums[l];
        nums[l] = a ;
        return j ;
    }
    public static void main(String[] args){
        KthLargestElementinanArray kthLargestElementinanArray = new KthLargestElementinanArray();
        int[] nums = {3,2,1,5,6,4} ;
        kthLargestElementinanArray.findKthLargest(nums,2);
    }
}   
