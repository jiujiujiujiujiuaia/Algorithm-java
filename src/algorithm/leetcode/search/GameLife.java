package algorithm.leetcode.search;

import edu.princeton.cs.algs4.StdIn;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

//二维数组 第一个是行
public class GameLife {
    //solution 1
    public int isLive(int x,int y,int[][] board){
        int live=0;
        int colunm = board[0].length;//列数
        int row = board.length;//行数
        for(int i=0;i<3;i++){
            if(x-1+i<0||x-1+i==row){
                continue;
            }
            for(int j=0;j<3;j++){
                if(y-1+j<0||y-1+j==colunm){
                    continue;
                }
                if(board[x-1+i][y-1+j]==1&&(x-1+i!=x||y-1+j!=y)){
                    live++;
                }
            }
        }
        switch (board[x][y]){
            case 1 : return live==2||live==3?1:0;
            case 0 : return live==3?1:0;
        }
        return 1;
    }


    public void gameOfLife(int[][] board) {
        if(board[0].length != 0){
            int hang = board.length;
            int lie = board[0].length;
            int[][] temp = new int[board.length][board[0].length];
            for(int i = 0;i<hang;i++){
                for(int j= 0;j<lie;j++){
                    temp[i][j] = isLive(i,j,board);
                }
            }

            for(int i =0;i<hang;i++){
                for(int j =0;j<lie;j++){
                    board[i][j] = temp[i][j];
                }
            }
        }
        else{

        }
    }

    //solution 2
    public void gameOfLife2(int[][] board) {
        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                int aliveNeighbours = getAliveNeighbours(board, r, c);
                if(board[r][c] == 0  && aliveNeighbours == 3){
                    board[r][c] = 2;
                }else if(board[r][c] == 1 && (aliveNeighbours < 2 || aliveNeighbours > 3)){
                    board[r][c] = 3;
                }
            }
        }

        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                board[r][c] = (board[r][c] == 3) ? 0 : (board[r][c] == 2) ? 1: board[r][c];
            }
        }
    }

    private int getAliveNeighbours(int board[][], int r, int c){
        int aliveNeighbours = 0;
        for(int i = (r-1 < 0 ? 0 : r-1); i <= (r+1 > board.length-1 ? board.length-1 : r+1) ; i++){
            for(int j = (c-1 < 0 ? 0 : c-1); j <= (c+1 > board[0].length -1 ? board[0].length -1 : c+1); j++){
                if(i == r && j == c) continue;
                if(board[i][j] == 1 || board[i][j] == 3)
                    aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }
    //solution3
    private static final int[][] dir = new int[][] {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public void gameOfLife3(int[][] board) {
        if (board.length == 0 || board[0].length == 0) return;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cnt = 0;
                for (int[] d : dir) {
                    int r = i + d[0], c = j + d[1];
                    if (validate(board, r, c) && (board[r][c] & 1) == 1) {
                        cnt++;
                    }
                }
                if (board[i][j] == 1 && (cnt == 2 || cnt == 3))
                    board[i][j] = 3;

                if (board[i][j] == 0 && cnt == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] >>> 1;
            }
        }
    }

    private boolean validate(int[][] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[0].length;
    }
    public static void main(String[] args){

    }
}
