class UnionFind {
    int[] father;
    int count;
    public UnionFind(int n, int count) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = -1;
        }
        this.count = count;
    }
    public int find(int a) {
        if (father[a] < 0) {
            return a;
        }
        father[a] = find(father[a]);
        return father[a];
    }
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) { // this is important we cannot merge them 
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
    public int getCount() {
        return count;
    }
}
public class Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    count++;
                }
            }
        }
        int n = grid.length;
        int m = grid[0].length;
        UnionFind uf = new UnionFind(n * m, count);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) {
                    if (i > 0 && grid[i - 1][j]) {
                        //if (uf.find(i * m + j) != uf.find((i - 1) * m + j)) {
                            uf.union(i * m + j, (i - 1) * m + j);
                        //}
                    }
                    if (i + 1 < n && grid[i + 1][j]) {
                        //if (uf.find(i * m + j) != uf.find((i + 1) * m + j)) {
                            uf.union(i * m + j, (i + 1) * m + j);
                        //}
                    }
                    if (j > 0 && grid[i][j - 1]) {
                        //if (uf.find(i * m + j) != uf.find(i * m + j - 1)) {
                            uf.union(i * m + j, i * m + j - 1);
                        //}
                    }
                    if (j + 1 < m && grid[i][j + 1]) {
                        //if (uf.find(i * m + j) != uf.find(i * m + j + 1)) {
                            uf.union(i * m + j, i * m + j + 1);
                        //}
                    }
                    grid[i][j] = false;
                } 
            }
        }
        return uf.getCount();
    }
}
