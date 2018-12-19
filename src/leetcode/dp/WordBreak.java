package leetcode.dp;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yuchunwei
 * leetcode 139
 */
public class WordBreak {
    //我这个思路也行 但是另一种思路可能更好 万一字典超级大 每一次都要全部遍历 没有contains来的快
    private boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1 ; i<=s.length();i++){
            for(int j = 0;j<wordDict.size();j++){
                if(s.substring(0,i).endsWith(wordDict.get(j))){
                    dp[i] = dp[i-wordDict.get(j).length()];
                    if(dp[i]) break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        String s = "catssandog";
        List<String> lists = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak.wordBreak(s,lists));
    }
}   
