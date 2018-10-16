class UnionFind {
    int[] father;
    int count;
    UnionFind(int n) {
        father = new int[n];
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
        for (int j = 0; j < list.size(); j++) {
            father[list.get(j)] = i;
        }
        return i;
    }
    void union(int i, int j) {
        int fi = find(i);
        int fj = find(j);
        if (fi != fj) {
            father[fi] = fj;
            count--;
        }
    }
    void addCount() {
        count++;
    }
    int query() {
        return count;
    }
}
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        List<Integer> list = new ArrayList<>();
        if (m * n == 0) {
            return list;
        }
        UnionFind uf = new UnionFind(n * m);
        for (int[] position : positions) {
            uf.addCount();
            grid[position[0]][position[1]] = 1;
            int x = position[0];
            int y = position[1];
            if (x > 0 && grid[x - 1][y] == 1) {
                uf.union(x * n + y, (x - 1) * n + y);
            }
            if (y > 0 && grid[x][y - 1] == 1) {
                uf.union(x * n + y, x * n + y - 1);
            }
            if (x < m - 1 && grid[x + 1][y] == 1) {
                uf.union(x * n + y, (x + 1) * n + y);
            }
            if (y < n - 1 && grid[x][y + 1] == 1) {
                uf.union(x * n + y, x * n + y + 1);
            }  
            list.add(uf.query());
        }
        return list;
    }
}
