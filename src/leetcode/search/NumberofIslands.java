package leetcode.search;


import edu.princeton.cs.algs4.In;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.Array;
import java.util.*;

public class NumberofIslands {
    private boolean[][] visited;
    private int row;//行
    private int column;//列
    private int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    private int count = 0;
    public int numIslands(char[][] grid) {
        row = grid.length;
        column = grid[0].length;
        visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if(grid[i][j] == '1' && !visited[i][j] ){
                    bfs(i,j,grid);count++;
                }
            }
        }
        return count;

    }

    private ArrayList<int[]> getAdj(int x,int y){
        ArrayList<int[]> result = new ArrayList<>();
        for(int[] dir:dirs){
            if(x+dir[0]<0||x+dir[0]==row||y+dir[1]<0||y+dir[1]==column){
                continue;
            }
            int[] temp = {x+dir[0],y+dir[1]};
            result.add(temp);
        }
        return result;
    }

    private void bfs(int x,int y,char[][] grid){
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(x,y));
        while(!queue.isEmpty()){
            List<Integer> list = queue.poll();
            int i =list.get(0);int j = list.get(1);
            for(int[] temp: getAdj(i,j)){
                if(!visited[temp[0]][temp[1]]&&grid[temp[0]][temp[1]] == '1'){
                    queue.add(Arrays.asList(temp[0],temp[1]));
                    visited[temp[0]][temp[1]] = true;
                }
            }
        }
    }

}
