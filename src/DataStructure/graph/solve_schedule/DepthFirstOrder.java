package DataStructure.graph.solve_schedule;

import DataStructure.graph.DirGraph;

import java.util.Stack;
//一个拓扑排序就是所有的逆后序
public class DepthFirstOrder {
    private boolean[] marked;
    private Stack<Integer> stack;

    public DepthFirstOrder(DirGraph G){
        marked = new boolean[G.getV()];
        stack = new Stack<>();
        for(int i =0;i<G.getV();i++){
            if(!marked[i]){

            }
        }
    }

    public void dfs(DirGraph G,int v){
        marked[v] = true;
        for(int w :G.getAdj(v)){
            if(!marked[w]){
                dfs(G,w);
            }
        }
        stack.push(v);
    }
}
