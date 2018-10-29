package DataStructure.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BroadFirstSearch {
    private boolean[] marked;
    private int[] edgeTo;
    private Graph G;
    private int s;

    private void bfs(Graph G,int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        marked[s] =true;
        while(!queue.isEmpty()){
            int v = ((LinkedList<Integer>) queue).pop();
            for(int w :G.getNeibour(v)){
                if(!marked[w]){
                    marked[w] = true;
                    edgeTo[w] = v;
                    queue.add(w);
                }
            }
        }
    }

    public static void main(String[] args){

    }
}
