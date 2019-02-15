class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};
        int[] parent = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            if (parent[edges[i][1]] == 0) {
                parent[edges[i][1]] = edges[i][0];
            } else {
                can2 = new int[] {edges[i][0], edges[i][1]};
                can1 = new int[] {parent[edges[i][1]], edges[i][1]};
                edges[i][1] = 0;//set invalid
            }
        }
        for (int i = 0; i < edges.length; i++) {
            parent[i] = i;
        } // 初始化union find
        
        for (int i = 0; i < edges.length; i++) {
            if (edges[i][1] == 0) {
                continue;
            } // 遇见第二个让edge[1]成为入度为2的点
            int child = edges[i][1];
            int father = edges[i][0];
            if (root(parent, father) == child) { // 有环
                if (can1[0] == -1) { // 没有candidate
                    return edges[i];
                }
                return can1;
            }
            parent[child] = father; // union 
        }
        return can2;
    }
    int root(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
