package algorithm.leetcode.array;

/**
 * @Author yuchunwei
 * algorithm.leetcode 167
 */
public class TwoSumII {
    //就双指针得思路
    public int[] twoSum(int[] numbers, int target) {
        int i = 0 ,j = numbers.length - 1 ;
        for(; j > i ; ){
            if(numbers[i] + numbers[j] > target) j--;
            else if(numbers[i] + numbers[j] < target) i++;
            else break;
        }
        return new int[]{i++,j++};
    }

}   
