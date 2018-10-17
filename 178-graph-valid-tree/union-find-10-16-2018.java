class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        for (int[] edge : edges) {
            int x = find(edge[0], father);
            int y = find(edge[1], father);
            if (x != y) {
                father[x] = y;
            } else {
                return false;
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (father[i] == i) {
                count++;
            }
            
        }
        return count == 1;    
    }
    
    
    int find(int x, int[] father) {
        while (x != father[x]) {
            x = father[x];
        }
        return x;
    }
}
