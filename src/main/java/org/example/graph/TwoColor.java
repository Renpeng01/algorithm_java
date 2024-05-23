package org.example.graph;

import java.util.regex.MatchResult;

public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColorable = true;

    public TwoColor(Graph graph) {
        marked = new boolean[graph.V()];
        color = new boolean[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                color[w] = !color[v];
                dfs(G, w);
            }else if(color[w] == color[v]){  // 下一个节点之前被marked，并且当前节点与先一个节点颜色相等，则为非二色图
                isTwoColorable = false;
            }
        }
    }

    public boolean isTwoColorable() {
        return isTwoColorable;
    }
}
