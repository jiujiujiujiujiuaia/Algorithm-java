package algorithm.algorithm4.graph.MST;

import java.util.ArrayList;
import java.util.List;

public class WeightGraph {
    private final int V;//返回所有边的数量
    private int E;
    private List<Edge>[] list;

    public WeightGraph(int v){
        this.V = v;
        list = (ArrayList<Edge>[]) new ArrayList[v];
        for(int i = 0;i<v;i++){
            list[i] = new ArrayList<Edge>();
        }
    }

    public void addEdge(Edge edge) throws Exception{
        int v = edge.getOne();int w = edge.getOtherOne(v);
        list[v].add(edge);list[w].add(edge);
    }

    public Iterable<Edge> getAdj(int v){
        return list[v];
    }

    public int getV(){
        return V;
    }

    public static void main(String[] args){

    }
}
