class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                q.add(i);
                color[i] = 0;
                while (!q.isEmpty()) {
                    int size = q.size();
                    for (int k = 0; k < size; k++) {
                        int temp = q.poll();
                        int col = color[temp];
                        for (int item : graph[temp]) {
                            if (color[item] == col) {
                                return false;
                            } else if (color[item] == -1) {
                                color[item] = 1 - col;
                                q.add(item);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
