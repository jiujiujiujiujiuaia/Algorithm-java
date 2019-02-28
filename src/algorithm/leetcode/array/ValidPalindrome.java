package algorithm.leetcode.array;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author yuchunwei
 * algorithm.leetcode 125
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        char[] chars = actual.toCharArray();
        int i = 0 , j = chars.length;
        while( i < j){
            if(chars[i] ==  chars[j]){
                i++;j--;
            }
            else return false;
        }
        return true;
    }

    public static void main(String[] args) {
    }
}   
