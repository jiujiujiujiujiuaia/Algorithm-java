package leetcode;

import java.lang.reflect.Array;
import java.util.*;
//没有考虑三个0的情况
public class ThreeSum {
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
}
