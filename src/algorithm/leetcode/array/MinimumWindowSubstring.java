package algorithm.leetcode.array;

import java.util.HashMap;

/**
 * @Author yuchunwei
 * algorithm.leetcode 76
 * 简述一下思路，首先把目标字符t中char放入map并记录频率，然后遍历s字符,如果发现了一个T得字符就减一，如果
 * 其结果频率仍然大于等于0说明，该字符还没有找齐，count++；直到count == t.size()，那么就可以缩小窗口
 * 左边界，来寻找最小窗口
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        HashMap<Character,Integer> map = new HashMap<>(128);
        int count = 0;
        int best  = Integer.MAX_VALUE;
        int i = 0,j = -1;
        //处理目标字符
        char[] chars = s.toCharArray();
        for(Character character : t.toCharArray()){
            map.put(character , map.getOrDefault(character, 0 ) + 1);
        }
        for(int left = 0 ,right = -1 ; left < s.length();){
            if(count < t.length() && right < s.length() - 1){
                if(map.containsKey(chars[++right])){
                    int temp = map.get(chars[right])- 1;
                    if(temp >= 0){
                        count++;
                    }
                    map.put(chars[right],temp);
                }
            }
            else {
                if(map.containsKey(chars[left])){
                    int temp = map.get(chars[left]);
                    if(temp == 0 && count == t.length()){
                        count --;
                        if(best > right - left + 1) {
                            best = right - left + 1;
                            i = left ;
                            j = right;
                        }
                    }
                    map.put(chars[left],temp + 1);
                }
                left++;
            }
        }

        return s.substring(i,j+1);

    }
    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring() ;
        System.out.println(minimumWindowSubstring.minWindow("ADOBECODEBANC","ABC"));
    }
}   
