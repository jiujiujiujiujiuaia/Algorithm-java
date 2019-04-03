package algorithm.leetcode;

/**
 * @Author yuchunwei
 * leetcode 14 最长公共前缀
 */
public class LongestCommonPrefix {

    //了解一下字典树 竟然还可以用字典树
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < strs[0].length() ; i++){
            char temp = strs[0].charAt(i);
            for(int j = 0 ; j < strs.length ;j++){
                if(i >= strs[j].length() ||strs[j].charAt(i) != temp) return builder.toString();
            }
            builder.append(temp);
        }
        return builder.toString();
    }

    public static void main(String[] args) {

    }
}   
