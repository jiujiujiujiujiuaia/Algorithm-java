package algorithm4.graph.solve_schedule;

import algorithm4.graph.DirGraph;

import java.util.ArrayList;
import java.util.List;
//判断有向图是否有环
public class DirectedCycle {
    private boolean[] marked;
    private boolean[] onStack;
    private List<Integer> cycle;
    private int[] edge;


    public DirectedCycle(DirGraph G){
        marked = new boolean[G.getV()];
        onStack = new boolean[G.getV()];
        edge = new int[G.getV()];
        for(int i = 0 ;i<G.getV();i++){
            if(!marked[i]){
                dfs(G,i);
            }
        }
    }

    private void dfs(DirGraph G,int v){
        marked[v] = true;
        onStack[v] = true;
        for(int w : G.getAdj(v)){
            if(this.hasCycle()){
                return ;
            }
            else if(!marked[w]){
                edge[w] = v;
                dfs(G,v);
            }
            else if(onStack[v]){
                cycle = new ArrayList<>();
                for(int x = v;x!=w;x=edge[x]){
                    cycle.add(x);
                }
                cycle.add(w);
                cycle.add(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle(){
        return cycle !=null;
    }

}
