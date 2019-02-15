class UnionFind {
    int[] father;
    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    public int find(int a) {
        if (father[a] == a) {
            return a;
        }
        return father[a] = find(father[a]);
    }
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            father[a] = b;
        }
    }
}

class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(4 * n * n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                int root = 4 * (i * n + j);
                switch(c) {
                    case '\\':
                        uf.union(root + 0, root + 1);
                        uf.union(root + 2, root + 3);
                        break;
                    case '/':
                        uf.union(root + 0, root + 3);
                        uf.union(root + 1, root + 2);
                        break;
                    case ' ':
                        uf.union(root + 0, root + 1);
                        uf.union(root + 1, root + 2);
                        uf.union(root + 2, root + 3);
                        break;
                }
                if (i + 1 < n) {
                    uf.union(root + 2, root + 4 * n + 0);
                }
                if (j + 1 < n) {
                    uf.union(root + 1, root + 4 + 3);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 4 * n * n; i++) {
            if (uf.find(i) == i) {
                res++;
            }
        }
        return res;
    }
}
