package leetcode.seek;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * @Author yuchunwei
 * leetcode 219
 */
public class ContainsDuplicateII {

    //思路一是利用map存储，然后不断更新，思路还是挺好想得
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
            else {
                int temp = map.get(nums[i]);
                if(i - temp <=k) return true;
                else map.put(nums[i],i);
            }
        }
        return false;
    }
    //思路二利用set来维持一个滑动窗口，当set得size大于k且滑动窗口中没有相同得值
    //那就把set第一个值删除
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(queue.contains(nums[i])) return true;
            ((LinkedList<Integer>) queue).add(nums[i]);
            if(queue.size() > k ) ((LinkedList<Integer>) queue).pop();
        }
        return false;
    }

    public static void main(String[] args) {
      Map map = new TreeMap();
    }
}   
