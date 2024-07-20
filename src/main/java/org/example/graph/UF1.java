package org.example.graph;

// quick-union
public class UF1 {
    private int[] id;
    private int count;
    private int[] sz;

    public UF1(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

        sz = new int[N];
        for (int i = 0; i < N; i++){
            sz[i] = 1;
        }
    }

    // 归并2个分量
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) {
            return;
        }
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    // 返回给定触点所在的连通分量的标识符
    int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    // 判断2个触点是否存在于同一个分量之上
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // 返回所有连通分量的数量
    public int count() {
        return count;
    }
}
