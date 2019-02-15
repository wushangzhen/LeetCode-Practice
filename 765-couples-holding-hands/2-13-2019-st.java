class UnionFind {
    public int[] father;
    public int count;
    public UnionFind(int n) {
        father = new int[n];
        Arrays.fill(father, -1);
        count = n;
    }
    public int find(int x) {
        if (father[x] < 0) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    public void union(int a, int b) {
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
    public int minSwapsCouples(int[] row) {
        int N = row.length / 2;
        UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            int a = row[2 * i];
            int b = row[2 * i + 1];
            uf.union(a / 2, b / 2);
        }
        return N - uf.count;
    }
}
