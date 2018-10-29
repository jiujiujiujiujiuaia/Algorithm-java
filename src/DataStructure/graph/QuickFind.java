package DataStructure.graph;

public class QuickFind {
    //unionFind慢就是因为，数组查询要比插入快得多得多
    //同样也有自己的缺点，那就是有一种极端情况，每一次连通的分量老是加到自己的队尾，那么就要从队尾不断遍历到队头
    private int[] ids;
    private int count;

    QuickFind(int N) {
        count = N;
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
    }

    private int find(int v) {
        while (ids[v] != v) v = ids[v];
        return v;
    }

    public void union(int v, int w) {
        int vId = find(v);
        int wId = find(w);
        if (vId == wId) {
            return;
        }
        ids[vId] = wId;
        count--;
    }

}
