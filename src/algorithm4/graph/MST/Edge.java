package algorithm4.graph.MST;

public class Edge {
    private final int v;
    private final int w;
    private final int weight;
    public Edge(int v,int w ,int weight){
        this.w = w;
        this.v = v;
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }
    public int getOne(){
        return v;
    }
    public int getOtherOne(int w) throws Exception{
        if(w == v) return this.w;
        else if(w == this.w) return v;
        else throw new Exception("这个边没有这个点");
    }
}
