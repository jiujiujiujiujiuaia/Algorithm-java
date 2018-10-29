package DataStructure.graph;

import java.util.ArrayList;

public class DirGraph {
    private ArrayList<Integer>[] adj;
    private int V;
    private int E;

    DirGraph(int V){
        this.V = V;
        adj = (ArrayList<Integer>[]) new ArrayList[V];
        for(int i = 0;i<adj.length;i++){
            adj[i] = new ArrayList<>();
        }
    }

    public int getV(){
        return V;
    }

    public void add(int start,int end){
        adj[start].add(end);
        E++;
    }
    public Iterable<Integer> getAdj(int v){
        return adj[v];
    }
    public void reverse(){
        ArrayList<Integer>[] temp = new ArrayList[adj.length];
        for(int i = 0;i<temp.length;i++){
            for(Integer a : adj[i]){
                temp[a].add(i);
            }
        }
        adj = temp;
    }
}
