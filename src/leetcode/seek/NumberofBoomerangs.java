package leetcode.seek;

import java.util.HashMap;

/**
 * @Author yuchunwei
 * leetcode 447
 */
public class NumberofBoomerangs {
    //这道题目有一个注意点就是因为涉及整型相乘，因此面试时需要问清楚x，y得坐标范围以免相乘过大导致超出范围
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        HashMap<Double, Integer> map  = new HashMap<>();
        for(int i = 0 ; i < points.length ; i ++){
            map = new HashMap<>();
            for(int j = 0 ; j < points.length ; j++){
                if(i != j ) {
                    int x = Math.abs(points[i][0] - points[j][0]);
                    int y = Math.abs(points[i][1] - points[j][1]);
                    double res = Math.sqrt(x * x + y * y);
                    map.put(res, map.getOrDefault(res, 0) + 1);
                }
            }
            for(Integer a : map.values()){
                if(a > 1){
                    count+=a*(a-1);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] p = {{1,0},{0,0},{2,0}};
        NumberofBoomerangs numberofBoomerangs = new NumberofBoomerangs();
        System.out.println(numberofBoomerangs.numberOfBoomerangs(p));
    }
}   
