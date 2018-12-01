package leetcode;

import java.lang.reflect.Array;
import java.util.*;
//没有考虑三个0的情况
public class ThreeSum {
    //这个办法效率太低,就是去模拟规则而已，以后尽量不去写这种模拟规则得题目
    private int result ;
    private Set<List<Integer>> arrayList= new HashSet<List<Integer>>();
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> pos = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ;i<nums.length;i++){
            if(nums[i]<0)  neg.add(nums[i]);
            else pos.add(nums[i]);
        }
        if(neg.isEmpty() || pos.isEmpty()){

        }
        else {
            if (neg.size() > 1) {
                seak(neg, pos);
            }
            if (pos.size() > 1) {
                seak(pos, neg);
            }
            for (List<Integer> list : arrayList) {
                lists.add(list);
            }
        }
        if(pos.size()>2 &&pos.get(2) == 0){
            lists.add(Arrays.asList(0,0,0));
        }
        return lists;
    }
    public boolean search(int target,List<Integer> nums){
        int h = nums.size()-1;
        int l = 0;
        int mid ;
        for(;h>=l;){
            mid = l+(h-l) / 2;
            if(nums.get(mid)>target) h = mid - 1;
            else if(nums.get(mid)<target) l = mid + 1;
            else {
                result= nums.get(mid);
                return true;
            }
        }
        return false;
    }
    public void seak(List<Integer> array1,List<Integer> array2 ){
        int temp;
        for(int i = 0;i<array1.size();i++){
            for(int j = i+1 ;j<array1.size();j++){
                if( (temp = array1.get(i)+array1.get(j))<= -array2.get(0) ){
                    if(search(-temp,array2)){
                        arrayList.add(Arrays.asList(result,array1.get(i),array1.get(j)));
                    }
                }
            }
        }
    }
    //solution2
    public List<List<Integer>> threeSum2(int[] nums) {
        int i,j,k;
        List<List<Integer>> lists = new ArrayList<>();
        if(nums.length > 2) {
            Arrays.sort(nums);
            for (k = 0; k < nums.length - 2; k++) {
                if (nums[k] > 0) break;
                if (k > 0 && nums[k] == nums[k - 1]) continue;//关键步骤
                int target = -nums[k];
                i = k + 1;
                j = nums.length - 1;
                while (j > i) {
                    if (target == nums[i] + nums[j]) {
                        lists.add(Arrays.asList(-target, nums[i], nums[j]));
                        //关键步骤
                        while (j > i && nums[i + 1] == nums[i]) i++;
                        while (j > i && nums[j] == nums[j - 1]) j--;
                        i++;
                        j--;
                    } else if (target > nums[i] + nums[j]) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
        return lists;
    }

}