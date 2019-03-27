class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        q.add(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[0] == destination[0] && temp[1] == destination[1]) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int x = temp[0] + dx[i];
                int y = temp[1] + dy[i];
                while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0) {
                    x += dx[i];
                    y += dy[i];
                } // this is important 
                if (!visited[x - dx[i]][y - dy[i]]) {
                    q.add(new int[]{x - dx[i], y - dy[i]});
                    visited[x - dx[i]][y - dy[i]] = true;
                }
            }
        }
        return false;
    }
}
