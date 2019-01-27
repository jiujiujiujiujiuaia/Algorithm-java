package leetcode.array;

/**
 * @Author yuchunwei
 * leetcode 344
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int pointL = 0 ,pointR = s.length - 1;
        for(;pointL < pointR ;){
            char temp = s[pointL];
            s[pointL] = s[pointR];
            s[pointR] = temp;
            pointL++;
            pointR--;
        }

    }

    public static void main(String[] args) {

    }
}   
