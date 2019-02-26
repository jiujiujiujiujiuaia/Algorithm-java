package algorithm4.graph;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;

public class Graph {
    private int V ;
    private int E ;
    private ArrayList<Integer>[] adj;

    public Graph(int v){
        V = v;
        E = 0;
        adj = new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i] = new ArrayList<Integer>();
        }
    }

    public Graph(){
        this(Integer.parseInt(StdIn.readString()));
        System.out.println("请输入边数");
        int E = Integer.parseInt(StdIn.readString());
        System.out.println("请输入路径对");
        for(int i=0;i<E;i++){
            int v = Integer.parseInt(StdIn.readString());
            int w = Integer.parseInt(StdIn.readString());
            addEdge(v,w);
        }
    }

    private void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E ++;
    }

    public ArrayList<Integer> getNeibour(int v){
        return adj[v];
    }

    public int point(){
        return V;
    }

    public int line(){
        return E;
    }
}
