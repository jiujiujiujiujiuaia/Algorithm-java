package leetcode.array;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author yuchunwei
 * leetcode 76
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        Set<Character> targetSet = new HashSet<>();
        Set<Character> tempSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (Character character : t.toCharArray()) {
            targetSet.add(character);
        }
        int l = 0, r = -1;
        int res1 = 0 , res2 = 0;
        int best = Integer.MAX_VALUE;
        char[] chars = s.toCharArray();
        while (l < s.length()) {
            if (tempSet.size() != targetSet.size()) {
                if (targetSet.contains(chars[r])) {
                    int temp = targetSet.size();
                    tempSet.add(chars[r]);
                    if (tempSet.size() > temp) ((LinkedList<Integer>) queue).add(r);
                    r++;
                } else {
                    l = ((LinkedList<Integer>) queue).pop();
                    tempSet.remove(chars[l]);
                    if((r - l + 1) < best){
                        best = r - l + 1;
                        res1 = l ;res2 = r;
                    }
                }
            }
        }
        return s.substring(l,r+1);
    }

    public static void main(String[] args) {

    }
}   
