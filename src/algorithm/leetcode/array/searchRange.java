package algorithm.leetcode.array;

/**
 * @Author yuchunwei
 * leetcode 34
 */
public class searchRange {

    //一次二分查找 然后根据查到为基础，分别从前从后找
    public static int[] searchRange(int[] nums, int target) {
        int l = 0 ,h = nums.length - 1 ;
        int index = -1 , end = -1 ,start = -1;
        while(l <= h){
            int mid = l + (h - l) / 2;
            if(target > nums[mid]) l = mid + 1;
            else if(target < nums[mid]) h = mid - 1;
            else {
                index = mid ;break;
            }
        }
        if(index == -1 ) return new int[]{-1,-1};
        int temp = index ;
        while(temp - 1 >= 0 && nums[temp-1] ==target){ // 1 这个地方一定要注意对数组越界的情况讨论
                                                        // 2 如果这里判断的是nums[temp] temp是
                                                         // 不为target的第一个数，如果是nums[temp - 1] temp是为target最后一个数
            temp--;
        }
        start = temp;
        while(index + 1 <=nums.length -1 && nums[index+1] == target){
            index++;
        }
        end = index;
        return new int[]{start,end};
    }
    //还有一种思路是两次二分查找
    public static int[] searchRange2(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int l = -1 , r = -1 ;
        if (nums.length == 0) return new int[]{-1, -1};
        int mid = -1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (mid - 1 >= 0 && nums[mid -1] == target) {
                    end = mid - 1;
                    continue;
                }
                break;
            }
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        if(nums[mid] != target) return new int[]{-1, -1};
        l = mid;
        start = mid ; end = nums.length - 1;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                if (mid + 1 <=nums.length -1 && nums[mid + 1] == target) {
                    start = mid + 1;
                    continue;
                }
                break;
            }
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        r = mid;
        return new int[]{l,r};
    }





    public static void main(String[] args) {
        int[] a = {2,2};
        searchRange2(a,2);
    }
}   
