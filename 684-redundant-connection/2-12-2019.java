class UnionFind {
    private int[] father;
    public UnionFind(int n) {
        father = new int[n];
        Arrays.fill(father, -1);
    }
    public int find(int x) {
        if (father[x] < 0) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }
    public boolean union(int a, int b) {
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
            return true;
        } else {
            return false;
        }
    }
}


class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int max = 0;
        for (int[] edge : edges) {
            max = Math.max(edge[1], max);
        }
        UnionFind uf = new UnionFind(max);
        for (int[] edge : edges) {
            if (!uf.union(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }
        return new int[2];
    }
}
