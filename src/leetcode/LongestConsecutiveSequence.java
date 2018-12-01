package leetcode;

import java.lang.reflect.Array;
import java.util.*;

//空数组的特殊情况没有考虑 数组排序后有同值得情况没有考虑
//借用了搜索的思路 也就是深度优先的想法 这个思路还是蛮快的 O（n）
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
    //solution2 借用了set 这个思路挺好
    public int longestConsecutive2(int[] nums){
        int res = 0;
        Set<Integer> s = new HashSet<Integer>();
        for (int num : nums) s.add(num);
        for (int num : nums) {
            if (s.remove(num)) {
                int pre = num - 1, next = num + 1;
                while (s.remove(pre)) --pre;
                while (s.remove(next)) ++next;
                res = Math.max(res, next - pre - 1);
            }
        }
        return res;
    }
    //这个思路主要是利用了优先队列可以排序的思路 然后判断的思路类似于set
    public int longestConsecutive3(int[] nums){
        Queue<Integer> q = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            q.add(nums[i]);
        }
        Integer last = Integer.MAX_VALUE;int max = 0;int len = 1;
        while(!q.isEmpty()){
            int val = q.remove();
            if(val==last) continue;
            if(val==last+1) len++;
            else len = 1;
            max = Math.max(len,max);
            last = val;
        }
        return max;
    }

    public static void main(String[] args){
        int[] a = {1,2,0,1};
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int b= longestConsecutiveSequence.longestConsecutive(a);
        System.out.println(b);
    }
}
