package SymbolTable.graph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    DepthFirstPaths(Graph G,int s){
        marked = new boolean[G.point()];
        edgeTo = new int[G.point()];
        this.s = s;
        dfs(G,s);
    }
    private void dfs(Graph G,int s){
        marked[s] = true;
        for(int w : G.getNeibour(s)){
            if(!marked[w]){
                edgeTo[w] = s ;
                dfs(G,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public List<Integer> pathTo(int v){
        ArrayList<Integer> list = new ArrayList<>();
        for(int x =v;x!=s;x=edgeTo[x]){
            list.add(x);
        }
        list.add(s);
        return list;
    }

    public static void main(String[] args){
        System.out.println("请输入点数");
        Graph graph = new Graph();
        int s = 0;
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(graph,s);
        String str = StdIn.readString();
        while(str!=""){
            ArrayList<Integer> list = (ArrayList<Integer>) depthFirstPaths.pathTo(Integer.parseInt(str));
            String path = "";
            for (Integer a : list) {
                path += a + "-";
            }
            System.out.println(path);
            str = StdIn.readString();
        }
    }
}
