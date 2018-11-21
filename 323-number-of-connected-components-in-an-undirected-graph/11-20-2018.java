class UnionFind {
    int[] father;
    int count;
    UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = -1;
        }
        count = n;
    }
    int find(int a) {
        if (father[a] < 0) {
            return a;
        }
        father[a] = find(father[a]);
        return father[a];
    }
    void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (father[a] < father[b]) {
                father[a] += father[b];
                father[b] = a;
            } else {
                father[b] += father[a];
                father[a] = b;
            }
            count--;
        }
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int a = uf.find(edge[0]);
            int b = uf.find(edge[1]);
            if (a != b) {
                uf.union(a, b);
            }
        }
        return uf.count;
        
    }
}
