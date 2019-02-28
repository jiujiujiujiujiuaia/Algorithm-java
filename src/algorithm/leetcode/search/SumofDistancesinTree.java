package algorithm.leetcode.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SumofDistancesinTree {
    //solution 1
    private ArrayList<Integer>[] list;
    private boolean[] marked;
    private int[] temp;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[] result = new int[N];
        if(N!=0) {
            temp= new int[N];
            list = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                list[i] = new ArrayList<>();
            }
            marked = new boolean[N];

            for (int i = 0; i < edges.length; i++) {
                put(edges[i][0], edges[i][1]);
            }
            for (int i = 0; i < N; i++) {
                result[i] = bfs(i);
                marked = new boolean[N];
                temp = new int[N];
            }
        }
        return result;
    }

    private void put(int i,int j){
        list[i].add(j);
        list[j].add(i);
    }

    private int bfs(int start){
        int total=0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        marked[start] =true;
        while(!queue.isEmpty()){
            int w = queue.poll();
            for(int v:list[w]){
                if(!marked[v]){
                    queue.add(v);
                    marked[v] = true;
                    temp[v] = temp[w]+1;
                    total+=temp[v];
                }
            }
        }
        return total ;
    }




    public static void main(String[] args){
        SumofDistancesinTree sumofDistancesinTree = new SumofDistancesinTree();
        int[][] a= {{0,1},{0,2},{2,3},{2,4},{2,5}};
        sumofDistancesinTree.sumOfDistancesInTree(6,a);
    }

}
