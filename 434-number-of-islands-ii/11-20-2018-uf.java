class UnionFind {
    int[] father;
    int count;
    UnionFind(int count) {
        father = new int[count];
        for (int i = 0; i < count; i++) {
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
            if (father[a] > father[b]) {
                father[b] += father[a];
                father[a] = b;
            } else {
                father[a] += father[b];
                father[b] = a;
            }
            count--;
        }
    }
    int getCount() {
        return count;
    }
    void setCount(int x) {
        this.count = x;
    }
}

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '0';
            }
        }
        UnionFind uf = new UnionFind(n * m);
        int len = positions.length;
        uf.setCount(0);
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        List<Integer> res = new ArrayList<>();
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            grid[x][y] = '1';
            int count = uf.getCount();
            uf.setCount(count + 1);
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || grid[nextX][nextY] == '0') {
                    continue;
                }
                uf.union(x * n + y, nextX * n + nextY);
            }
            res.add(uf.getCount());
        }
        return res;
    }
}
