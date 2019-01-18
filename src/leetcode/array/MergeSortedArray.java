package leetcode.array;

import java.util.Arrays;

/**
 * @Author yuchunwei
 * leetcode
 */
public class MergeSortedArray {
    //有点复杂
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = 0 ,j = 0 ,i = 0;
        for( ; i < nums1.length && j < n ;){
            if(k == m)nums1[i++] = nums2[j++];
            else if(nums1[k] <= nums2[j]) {
                k++;
                i++;
            }
            else {
                int temp = nums1[k];
                nums1[k] = nums2[j] ;
                nums2[j] = temp;
                k++;i++;
                Arrays.sort(nums2);
            }
        }
    }
    //从后往前填
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1; int j = m - 1 ;int k = n - 1 ;
        for(; i > -1 && k > -1 ;){
            if(j < 0 ) nums1[i--] = nums2[k--];
            else if (nums1[j] >= nums2[k]) nums1[i--] = nums1[j--];
            else nums1[i--] = nums2[k--];
        }
    }
    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(num1,3,num2,3);
    }
}   
