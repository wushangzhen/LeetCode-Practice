class UnionFind {
    int[] father;
    int count;
    public UnionFind(int n) {
        this.father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    int find(int i) {
        List<Integer> list = new ArrayList<>();
        while (father[i] != i) {
            list.add(i);
            i = father[i];
        }
        for (Integer j : list) {
            father[j] = i;
        }
        return i;
    }
    void union(int i, int j) {
        int f1 = find(i);
        int f2 = find(j);
        if (f1 != f2) {
            father[f1] = f2;
            count--;
        }
    }
    void setCount(int x) {
        count = x;
    }
    int query() {
        return count;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    total++;
                }
            }
        }
        UnionFind uf = new UnionFind(m * n);
        uf.setCount(total);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') {
                        uf.union(i * m + j, (i - 1) * m + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        uf.union(i * m + j, i * m + (j - 1));
                    }
                    if (i < n - 1 && grid[i + 1][j] == '1') {
                        uf.union(i * m + j, (i + 1) * m + j);
                    }
                    if (j < m - 1 && grid[i][j + 1] == '1') {
                        uf.union(i * m + j, i * m + (j + 1));
                    }
                }
            }
        }
        return uf.query();
    }
}
