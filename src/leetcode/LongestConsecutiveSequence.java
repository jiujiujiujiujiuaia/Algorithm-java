package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
//空数组的特殊情况没有考虑 数组排序后有同值得情况没有考虑
public class LongestConsecutiveSequence {
    private boolean[] visit;
    private int[] nums;
    private int ids = -1;
    private int[] result;
    private int length;
    public int longestConsecutive(int[] nums) {
        length = nums.length;
        if(length >0) {
            Arrays.sort(nums);
            this.nums = nums;
            visit = new boolean[length];
            result = new int[length];
            for (int i = 0; i < nums.length; i++) {
                if (!visit[i]) {
                    ids++;
                    result[ids] = 1;
                    caculate(i);
                }
            }
            Arrays.sort(result);
            return result[length - 1];
        }
        return 0;
    }

    private void caculate(int i){
        visit[i] = true;
        if(i < length-1 && nums[i]+1 == nums[i+1]) {
            result[ids]+=1;
            caculate(i+1);
        }
        else if(i < length-1 && nums[i] == nums[i+1]){
            caculate(i+1);
        }
    }

    public static void main(String[] args){
        int[] a = {1,2,0,1};
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int b= longestConsecutiveSequence.longestConsecutive(a);
        System.out.println(b);
    }
}
