package org.example.graph;

import java.util.Arrays;

// quick-find
public class UF {

    private int[] id; // 分量id（以触点作为索引）
    private int count; // 分量数量

    public UF(int N){
        count = N;
        id = new int[N];
        for (int i = 0; i < N;i++){
            id[i] = i;
        }
    }

    // 归并2个分量
    public void union(int p, int q){
        int pID = find(p);
        int qID = find(q);
        if (pID == qID){
            System.out.println(Arrays.toString(id));
            return;
        }
        for(int i = 0; i < id.length;i++){
            if(id[i] == pID){
                id[i] = qID;
            }
        }
        count--;
        System.out.println(Arrays.toString(id));
    }

    // 返回给定触点所在的连通分量的标识符
    int find(int p){
        return id[p];
    }

    // 判断2个触点是否存在于同一个分量之上
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    // 返回所有连通分量的数量
    public int count(){
        return count;
    }

    public static void main(String[] args){
        UF uf = new UF(10);
        // 9-0
        // 3-4
        // 5-8
        // 7-2
        // 2-1
        // 5-7
        // 0-3
        // 4-2
        uf.union(9,0);
        uf.union(3,4);
        uf.union(5,8);
        uf.union(7,2);
        uf.union(2,1);
        uf.union(5,7);
        uf.union(0,3);
        uf.union(4,2);
    }
}
