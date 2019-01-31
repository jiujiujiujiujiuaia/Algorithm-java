package leetcode.array;

import java.util.Arrays;
import java.util.Collections;

/**
 * @Author yuchunwei
 * leetcode 3
 * 有关字符串的问题，要注意利用subString获得字串，字串的索引就会改变
 */
public class LongestSubstringWithoutRepeatingCharacters {
    //利用了String类的api
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int best = 0;
        int i = 0 ,j = 0;
        for( ; j < chars.length; j ++){
            if( s.substring(i,j ).contains(Character.toString(chars[j]))){
                best = Math.max(best , j - i  );
                int temp = s.indexOf(Character.toString(chars[j]),i); //运用了indexOf这个api
                i = temp + 1;
            }
        }
        best = Math.max(best , j  - i );
        return best ;
    }
    //思路二 如果不适用Stringd的api
    //那么就需要记录重复数组是否含有某个字符，肯定不能遍历，可以用一个数组记录，以ASCII为key来记录
    public int lengthOfLongestSubstring2(String s) {
        int[] freq = new int[256];
        Arrays.fill(freq,-1);
        char[] chars = s.toCharArray();
        int best = 0;
        int i = 0 ,j = 0;
        for( ; j < chars.length; j ++){
            if(freq[chars[j]] == -1){
                freq[chars[j]] = j;
            }
            else {
                best = Math.max(best , j - i  );
                i = freq[chars[j]] + 1;
                if(i == j) Arrays.fill(freq,-1);
                freq[chars[j]] = j ;
            }
        }
        best = Math.max(best , j  - i );
        return best;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcabcbb";
        a.lengthOfLongestSubstring2(s);
        System.out.println(s.substring(0,3));
    }
}   
