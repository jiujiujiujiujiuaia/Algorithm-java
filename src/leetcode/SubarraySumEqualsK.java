package leetcode;

import java.util.HashMap;

//  leetcode
//  560
public class SubarraySumEqualsK {
    //这个地方运用了前缀和的方法
    //暴力加前缀和解决这个问题
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int result = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                result+=nums[j];
                if(result == k) {
                    count++;
                }
            }
            result = 0;
        }
        return count;
    }
    //solution2 这里是利用了pre[i] - pre[j] 等于 从 j+1到i的序列 然后逐一的遍历来计算
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        int[] preSum = new int[nums.length];
        for(int i = 1 ; i < nums.length;i++){
            preSum[i] = preSum[i-1] + nums[i];
            for(int j = 0; j < i ;j++){
                if(preSum[i] - preSum[j] == k ){
                    count++;
                }
            }
        }
        return count;
    }
    //solution3 O(n)算法 最优解 遍历一遍数组得到所有的前缀和 pre[i] - pre[j] = k -> pre[i] - k = pre[j]
    public int subarraySum3(int[] nums, int k) {
        if(nums.length == 0) return 0;
        HashMap<Integer,Integer> hashMap = new HashMap<>();//key : 前缀和 value:出现次数
        hashMap.put(0,1);//pre = 0 代表两个意思 一个从 i 到 j 的值等于 k 另一种是 i的值等于 k
        int count = 0;
        int preSum = 0;
        for(int a : nums){
            preSum+=a;
            count+=hashMap.getOrDefault(preSum - k,0);
            hashMap.put(preSum,hashMap.getOrDefault(preSum,0)+1);
        }
        return count;
    }
    public static void main(String[] args){
        int[] nums = {1 , 2 , -3 , 3 , 3};
        SubarraySumEqualsK subarraySumEqualsK = new SubarraySumEqualsK();
        subarraySumEqualsK.subarraySum3(nums,3);
    }
}
