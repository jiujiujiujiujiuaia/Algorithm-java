package algorithm.newcoder.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yuchunwei
 * 打印循环矩阵
 */
public class Code17 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        List<Integer> list = new ArrayList<>();
        int total = matrix.length * matrix[0].length;
        int count = 0;
        int start = 0 ,end = 0 ;
        while (count < total){
            int x = start,y = end;
            int row = matrix.length - 1 - start,cols = matrix[0].length - 1 - end;
            for(; y < cols ; y++){
                if(count == total) break;
                count++;
                list.add(matrix[x][y]);
            }
            for(; x<row ;x++){
                if(count == total) break;
                count++;
                list.add(matrix[x][y]);
            }
            for(; y>end;y--){
                if(count == total) break;
                count++;
                list.add(matrix[x][y]);
            }
            for(;x>=start+1;x-- ){
                if(count == total) break;
                count++;
                list.add(matrix[x][y]);
            }
            start++;end++;
        }
        return (ArrayList<Integer>) list;
    }

    public static void main(String[] args) {
        int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        Code17 code17 = new Code17();
        code17.printMatrix(m);
    }
}   
