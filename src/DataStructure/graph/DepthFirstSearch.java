package graph;

public class DepthFirstSearch {
    private Graph G;
    private boolean[] marked;
    private int total;

    public DepthFirstSearch(Graph G ,int v){
        marked = new boolean[G.point()];
        dfs(G,v);
    }

    public boolean marked(int v){
        return marked[v];
    }

    public int total(){
        return total;
    }

    public void dfs(Graph G,int v){
        marked[v] = true;
        total++;
            for(int w : G.getNeibour(v)){
            if(!marked(w)){
                dfs(G,w);
            }
        }
    }

}
