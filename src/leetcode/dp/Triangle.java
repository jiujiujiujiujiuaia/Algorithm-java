package leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
    private Integer[][] dp;
    private int length;
    public int minimumTotal(List<List<Integer>> triangle) {
        length = triangle.size();
        dp = new Integer[length][length];
//        dp = init(length);
        return caculate(0,0,triangle);
    }

    private int caculate(int i ,int j ,List<List<Integer>> triangle){
        if(dp[i][j] !=null) return dp[i][j];
        int temp = i == length-1 ? 0:Math.min(caculate(i+1,j,triangle),caculate(i+1,j+1,triangle));
        int result =  triangle.get(i).get(j) +  temp;
        dp[i][j] = result;
        return result;
    }
    public static void main(String[] args){
        Triangle triangle = new Triangle();
        List<List<Integer>> lists =new ArrayList<>();
        Collections.addAll(lists,Arrays.asList(2),Arrays.asList(3,4),Arrays.asList(6,5,7),Arrays.asList(4,1,8,3));
        System.out.println(triangle.minimumTotal(lists));
    }
}
