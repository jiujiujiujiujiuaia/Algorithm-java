package leetcode.search;

import java.util.ArrayList;
import java.util.HashSet;

public class MakingALargeIsland {
    private int[][] marked;
    private int[] counts;//索引是id;
    private int row;//行
    private int colunm;//列
    private int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    private int count = 1;
    public int largestIsland(int[][] grid){
        row = grid.length;
        if(row !=0) {
            colunm = grid[0].length;
            counts = new int[row * colunm];
            marked = new int[row][colunm];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < colunm; j++) {
                    if (marked[i][j] == 0 && grid[i][j] == 1) {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            int max = 0;
            int temp;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < colunm; j++) {
                    if (grid[i][j] == 0) {
                        if ((temp = maxNum(i, j, grid)) > max) {
                            max = temp;
                        }
                    }
                }
            }
            return max == 0 ? row * colunm : max;
        }
        return 0;
    }

    private int maxNum(int x,int y,int[][] grid){
        HashSet<Integer> set = new HashSet<>();
        for(int[] temp : getAdj(x,y,grid)){
            set.add(marked[temp[0]][temp[1]]);
        }
        int result = 0;
        for(Integer a : set){
            if(a==0){
                continue;
            }
            result+=counts[a-1];
        }
        return result+1;
    }

    private Iterable<int[]> getAdj(int x,int y,int[][] grid){
        ArrayList<int[]>  list = new ArrayList<>();
        for(int[] temp : dir){
            if(x+temp[0]<0||x+temp[0]>=row||y+temp[1]<0||y+temp[1]>=colunm){
                continue;
            }
            int[] result= {x+temp[0],y+temp[1]};
            list.add(result);
        }
        return list;
    }

    private void dfs(int[][] grid,int x,int y){
        marked[x][y] = count;
        counts[count-1]++;
        for(int[] temp :getAdj(x,y,grid)){
            if(marked[temp[0]][temp[1]]==0&&grid[temp[0]][temp[1]]!=0){
                dfs(grid,temp[0],temp[1]);
            }
        }
    }

    public static void main(String[] args){
        MakingALargeIsland makingALargeIsland  = new MakingALargeIsland();
        int[][] grid = {{1,0}};
        System.out.println(makingALargeIsland.largestIsland(grid));
    }

}
