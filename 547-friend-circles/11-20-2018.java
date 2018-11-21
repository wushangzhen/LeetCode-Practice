class UnionFind {
    int[] father;
    int count;
    UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = -1;
        }
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
    public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n * n);
        uf.count = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
}
