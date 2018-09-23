class UnionFind {
    private int[] father;
    private int count;
    UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    public int find(int a) {
        List<Integer> list = new ArrayList<>();
        while(father[a] != a) {
            list.add(a);
            a = father[a];
        }
        for (int l : list) {
            father[l] = a;
        }
        return a;
    }
    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            count--;
        }
    }
    public int query() {
        return count;
    }
    public void setCount(int x) {
        count = x;
    }
}
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null) {
            return 0;
        }
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        if (grid[0] == null) {
            return 0;
        }
        int m = grid[0].length;
        if (m == 0) {
            return 0;
        }
        UnionFind unionFind = new UnionFind(n * m);
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    total++;
                }
            }
        }
        unionFind.setCount(total);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    if (i > 0 && grid[i - 1][j]) {
                        unionFind.union(i * m + j, (i - 1) * m + j);
                    }
                    if (i < n - 1 && grid[i + 1][j]) {
                        unionFind.union(i * m + j, (i + 1) * m + j);
                    }
                    if (j > 0 && grid[i][j - 1]) {
                        unionFind.union(i * m + j, i * m + j - 1);
                    }
                    if (j < m - 1 && grid[i][j + 1]) {
                        unionFind.union(i * m + j, i * m + j + 1);
                    }
                }
            }
        }
        return unionFind.query();
    }
}
