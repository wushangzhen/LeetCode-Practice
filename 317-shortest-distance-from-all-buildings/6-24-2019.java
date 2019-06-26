class Solution {
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] num = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int sum = 0;
        int[][] ds = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    sum++;
                    boolean[][] visited = new boolean[n][m];
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    int level = 0;
                    while (!q.isEmpty()) {
                        int size = q.size();
                        while (size-- > 0) {
                            int[] p = q.poll();
                            for (int[] d : ds) {
                                int nx = p[0] + d[0];
                                int ny = p[1] + d[1];
                                if (nx < 0 || ny < 0 || nx >= n || ny >= m || grid[nx][ny] != 0 || visited[nx][ny]) {
                                    continue;
                                }
                                dist[nx][ny] += level + 1;
                                num[nx][ny]++;
                                visited[nx][ny] = true;
                                q.add(new int[]{nx, ny});
                            }
                        }
                        level++;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dist[i][j] < min && num[i][j] == sum) {
                    min = dist[i][j];
                }   
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
