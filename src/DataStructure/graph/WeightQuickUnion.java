package DataStructure.graph;

public class WeightQuickUnion {
    private int[] ids;
    private int[] size;
    private int count;

    WeightQuickUnion(int N){
        count = N;
        ids = new int[N];
        size = new int[N];
        for(int i = 0;i<N;i++){
            ids[i] = i;size[i] = 1;
        }
    }
    public int find(int v){
        while (v !=ids[v] ) v = ids[v];
        return v;
    }
    public void union(int v,int w){
        int vId= find(v);
        int wId = find(w);
        if(vId == wId) return ;

        if(size[vId]>size[wId]){
            ids[wId] = vId;size[vId] += size[wId];
        }
        else{
            ids[vId] = wId;size[wId]+=size[vId];
        }
    }
}
