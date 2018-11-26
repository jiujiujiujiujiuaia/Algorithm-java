package leetcode;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                result+=nums[j];
                if(result > k) break;
                else if(result == k) {
                    count++;
                    break;
                }
            }
            result = 0;
        }
        return count;
    }
    public static void main(String[] args){
        int[] a = {28,54,7,-70,22,65,-6};
        int k = 100;
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        System.out.println(subarraySumEqualsK.subarraySum(a,k));
    }
}
