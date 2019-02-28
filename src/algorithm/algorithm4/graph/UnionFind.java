package algorithm.algorithm4.graph;

public class UnionFind {
    private int count;//count是一共多少个点，最坏的情况是互不连接，就是10个分量，每有两两连接一次，就自减
    private int[] id;

    UnionFind(int N){
        count = N;
        id = new int[N];
        for(int i = 0;i<N;i++){
            id[i] = i;
        }
    }

    private int find(int v){
        return id[v];
    }

    public void union(int v , int w){
        int vId = find(v);
        int wId  = find(w);

        if(vId == wId) return ;
        for(int i =0;i<id.length;i++){
            if(id[i] == vId) id[i] = wId;
        }
        count--;
    }

    public int count(){
        return count;
    }
    public static void main(String[] args){
        UnionFind unionFind = new UnionFind(6);
        unionFind.union(1,2);
        unionFind.union(1,3);
        unionFind.union(2,3);
        unionFind.union(4,5);
        System.out.println(unionFind.count());
    }
}
