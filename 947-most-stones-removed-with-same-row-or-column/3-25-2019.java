class UnionFind {
    int[] father;
    public UnionFind(int N) {
        father = new int[N];
        for (int i = 0; i < N; i++) {
            father[i] = i;
        }
    }
    public int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        father[y] = x;
    }
}

class Solution {
    public int removeStones(int[][] stones) {
        int N = stones.length;
        UnionFind uf = new UnionFind(20000);
        for (int[] stone : stones) {
            uf.union(stone[0], stone[1] + 10000);
        }
        Set<Integer> seen = new HashSet<>();
        for (int[] stone : stones) {
            seen.add(uf.find(stone[0]));
        }
        return N - seen.size();
    }
}
