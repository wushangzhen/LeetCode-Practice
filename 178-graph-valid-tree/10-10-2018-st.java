class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        for (int[] edge : edges) {
            int fa = find(father, edge[0]);
            int fb = find(father, edge[1]);
            if (fa == fb) {
                return false;
            }
            union(father, fa, fb);
        }
        return edges.length == n - 1;
    }
    int find(int[] father, int i) {
        while (father[i] != i) {
            i = father[i];
        }
        return i;
    }
    void union(int[] father, int i, int j) {
        int l = find(father, i);
        int r = find(father, j);
        if (l != r) {
            father[l] = r;
        }
    }
}
