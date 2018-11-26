package leetcode.dp;

import edu.princeton.cs.algs4.StdIn;
// not in leetcode
public class Rectangle {
    private int total ;//矩形的总数
    private int[][] G;//临界矩阵;
    private int[] x,y;//矩形的长宽；
    private int[] dp;//记录dp;

    public Rectangle(int[][] G, int total){
        this.G  = G;
        this.dp = new int[total];
        this.total = total;
    }

    //参数是矩形的编号
    public int dp(int i){
        if(dp[i]>0) return dp[i] ;
        dp[i] = 1 ;
        for(int j = 0;j<total;j++){
            if(G[i][j]>0){
                dp[i] = Math.max(dp[i],dp(j)+1);
            }
        }
        return dp[i] ;
    }

    public int[] getDp(){
        return dp;
    }

    public void printOder(int i){
        System.out.println(i);
        for(int j =0;j<total;j++){
            if(G[i][j] == 1&& dp[i] == dp[j] + 1){
                printOder(j);
                break;
            }
        }
    }

    public static void main(String[] args){
        System.out.println("请输入一共有多少个矩形:");
        int total = StdIn.readInt();
        int[] x= new int[total];
        int[] y= new int[total];
        int[][] G = new int[total][total];
        for(int i = 0 ;i<total;i++){
            System.out.println("请输入矩形的长宽");
            x[i] = StdIn.readInt();
            y[i] = StdIn.readInt();
            if(x[i]<y[i]){
                int j = x[i];
                x[i] = y[i];
                y[i] = j;
            }
        }
        for(int i = 0;i<total;i++){
            for(int j = 0 ;j<total;j++){
                if(x[i]<x[j] && y[i]<y[j]){
                    G[i][j] = 1;
                }
            }
        }
        Rectangle rectangle = new Rectangle(G,total);
        int max = 0;int order=0;
        for(int i = 0;i<total;i++){
            int temp = rectangle.dp(i);
            if(temp>max){
                order = i;
                max = temp;
            }
        }
        System.out.println("最多"+max+"矩形嵌套");
        rectangle.printOder(order);
    }
}
