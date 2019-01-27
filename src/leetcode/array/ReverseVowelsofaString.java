package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yuchunwei
 * leetcode 345
 */
public class ReverseVowelsofaString {
    private List<Character> arrayList = Arrays.asList('a','e','i','o','u');

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start = 0 , end = chars.length - 1;
        while (start < end){
            if(!arrayList.contains(chars[start])) start++;
            if(!arrayList.contains(chars[end])) end -- ;
            if(arrayList.contains(chars[start]) && arrayList.contains(chars[end])) {
                char temp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = temp;
            }
        }
        return chars.toString();
    }

}   
