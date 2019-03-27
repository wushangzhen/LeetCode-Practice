class Solution {
    public int shortestBridge(int[][] A) {
        boolean found = false;
        int n = A.length;
        int m = A[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        mark: for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    if (found) {
                        break mark;
                    }
                    if (A[i][j] == 1) {
                        dfs(i, j, A, visited, q);
                        found = true;
                    }
                }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                for (int j = 0; j < 4; j++) {
                    int x = temp[0] + dx[j];
                    int y = temp[1] + dy[j];
                    if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y]) {
                        continue;
                    }
                    if (A[x][y] == 1) {
                        return step - 1;
                    }
                    q.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return step;
    }
    void dfs(int x, int y, int[][] A, boolean[][] visited, Queue<int[]> q) {
        if (x < 0 || x >= A.length || y < 0 || y >= A[0].length || visited[x][y] || A[x][y] != 1) {
            return;
        }
        q.add(new int[]{x, y});
        visited[x][y] = true;
        dfs(x + 1, y, A, visited, q);
        dfs(x - 1, y, A, visited, q);
        dfs(x, y + 1, A, visited, q);
        dfs(x, y - 1, A, visited, q);
    }
}
