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
    //思路二 如果不采用String的api
    //那么就需要记录重复数组是否含有某个字符，肯定不能遍历，可以用一个数组记录，以ASCII为key来记录
    //感觉思路二是思路三的加强版本 当发现了一个重复的字符，不是慢慢的往前遍历寻找，而是利用数组已经记录的信息
    //直接增加左指针的位置
    public int lengthOfLongestSubstring2(String s) {
        int[] freq = new int[256];
        Arrays.fill(freq,-1);
        char[] chars = s.toCharArray();
        int best = 0;
        int i = 0 ,j = 0;
        for( ; j < chars.length; j ++){
            if(freq[chars[j]] == -1){
                freq[chars[j]] = j; //给从未出现的字符赋值他们的索引
            }
            else {
                if(freq[chars[j]] < i ) {
                    freq[chars[j]] = j;//eg:"abba"当左指针滑到1时 右指针遍历到3 会使左指针产生重复
                    continue;
                }
                best = Math.max(best , j - i  );
                i = freq[chars[j]] + 1;
                freq[chars[j]] = j ;
            }
        }
        best = Math.max(best , j  - i ); // 处理那种一整个字符串都没有重复的
        return best;
    }
    //思路三
    //同样是使用了数组记录词的频率 但是这样写法更简洁
    //如果没有遇到重复字串，右指针往前移动，如果遇到了有可能重复的，则左指针不断滑动直到找到为止
    public int lengthOfLongestSubstring3(String s) {
        int[] freq = new int[256];
        Arrays.fill(freq,0);
        int l = 0 ,r = -1;
        int res = 0;
        char[] chars = s.toCharArray();
        while ( l < s.length()){
            if(r + 1 < s.length() && freq[chars[r + 1]]  == 0){
                freq[chars[++r]]++;
            }
            else freq[chars[l++]] -- ;

            res = Math.max(res , r - l + 1);
        }
        return res ;
    }


    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcc";
        a.lengthOfLongestSubstring3(s);
        System.out.println(s.substring(0,3));
    }
}   
