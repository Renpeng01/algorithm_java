package org.example.graph;

public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Graph G, int v) {
        marked = new boolean[G.V()];
        dfs(G, v);
    }

    public DirectedDFS(Graph G, Iterable<Integer> source){
        marked = new boolean[G.V()];
        for (int s : source) {
            if (!marked[s]) dfs(G, s);
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean isMarked(int v) {
        return marked[v];
    }
}
