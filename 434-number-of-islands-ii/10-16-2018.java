class UnionFind {
    int[] father;
    int count;
    UnionFind(int x) {
        father = new int[x];
        for (int i = 0; i < x; i++) {
            father[i] = i;
        }
    }
    int find(int x) {
        List<Integer> list = new ArrayList<>();
        while (father[x] != x) {
            list.add(x);
            x = father[x];
        }
        for (Integer item : list) {
             father[item] = x;
        }
        return x;
    }
    void union(int x, int y) {
        int fa = find(x);
        int fb = find(y);
        if (fa != fb) {
            father[fa] = fb;
            count--;
        }
    }
    void setCount(int x) {
        count = x;
    }
    int query() {
        return count;
    }
    void addCount() {
        count++;
    }
}
class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> list = new ArrayList<>();
        if (positions == null || positions.length == 0) {
            return list;
        }
        char[][] grid = new char[m][n];
        for (char[] gri : grid) {
            for (char g : gri) {
                g = '0';
            }
        }
        UnionFind uf = new UnionFind(m * n);
        uf.setCount(0);
        for (int[] position : positions) {
            uf.addCount();
            int x = position[0];
            int y = position[1];
            grid[x][y] = '1';
            if (x < m - 1 && grid[x + 1][y] == '1') {
                uf.union(x * n + y, (x + 1) * n + y);
            }
            if (x > 0 && grid[x - 1][y] == '1') {
                uf.union(x * n + y, (x - 1) * n + y);
            }
            if (y < n - 1 && grid[x][y + 1] == '1') {
                uf.union(x * n + y, x * n + y + 1);
            }
            if (y > 0 && grid[x][y - 1] == '1') {
                uf.union(x * n + y, (x * n + y - 1));
            } 
            list.add(uf.query());
            
        }
        return list;      
    }
}
