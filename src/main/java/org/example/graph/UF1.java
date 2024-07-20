package org.example.graph;

// quick-union
public class UF1 {
    private int[] id;
    private int count;

    public UF1(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // 归并2个分量
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (qRoot == pRoot) {
            return;
        }
        id[qRoot] = pRoot;
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
