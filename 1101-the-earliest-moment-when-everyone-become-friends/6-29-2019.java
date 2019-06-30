class UnionFind {
    int[] father;
    int count;
    public UnionFind(int n) {
        count = n;
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            father[a] = father[b];
            count--;
        }
    }
}

class Solution {
    public int earliestAcq(int[][] logs, int N) {
        UnionFind uf = new UnionFind(N);
        int res = 1000000001;
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));
        for (int[] log : logs) {
            uf.union(log[1], log[2]);
            if (uf.count == 1) {
                return log[0];
            }
        }
        return -1;
    }
}
