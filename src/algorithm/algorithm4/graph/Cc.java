package algorithm.algorithm4.graph;

public class Cc {
    private boolean[] marked;
    private int count = 1;
    private int[] ids;

    public Cc(Graph G){
        ids = new int[G.point()];
        marked = new boolean[G.point()];
        for(int i = 0;i<G.point();i++){
            if(!marked[i]){
                dfs(G,i);
                count++;
            }
        }
    }

    public void dfs(Graph G,int s){
        marked[s] = true;
        ids[s] = count;
        for(int w :G.getNeibour(s)){
            if(!marked[w]) {
               dfs(G,s);
            }
        }
    }
 }
