package algorithm.newcoder.offer;

import middleware.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author yuchunwei
 * 寻找字符串(没有接出来)
 */
public class Code12 {
    private int row = 0;
    private int cols = 0;
    private List<List<Integer>> list = new ArrayList<>();
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        char[][] m = new char[rows][cols];
        for(int i = 1 ; i <= rows ;i++){
            for(int j = 1 ; j <= cols ;j++){
                m[i-1][j-1] = matrix[(i-1) * cols + j-1];
            }
        }
        if(m[0].length == 0) return false;
        list.add(Arrays.asList(0,1));
        list.add(Arrays.asList(1,0));
        list.add(Arrays.asList(-1,0));
        list.add(Arrays.asList(0,-1));
        this.row = rows;
        this.cols = cols;
        boolean[][] mark = new boolean[rows][cols];
        boolean a = help(m,mark,0,0,str,0);
        return a;
    }
    private boolean help(char[][] matrix,boolean[][] mark, int x , int y , char[] str,int i ){
        boolean m[][] = mark.clone();
        m[x][y] = true;
        if(matrix[x][y] == str[i]) i++;
        else i = 0;
        if(i == str.length) return true;
        for(int k = 0 ; k < 4 ; k++){
            int xx = list.get(k).get(0);
            int yy = list.get(k).get(1);
            if(x+xx>=0 && x+xx<=row-1 && y+yy>=0 && y+yy<=cols-1 && !mark[x+xx][y+yy] ){
                return help(matrix,m,xx+x,y+yy,str,i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code12 code12 = new Code12();
        char[] m = {'a','b','t','g','c','f','c','s','j','d','e','h'};
        char[] target = {'b','f','c','e'};
        System.out.println(code12.hasPath(m,3,4,target));
    }
}   
