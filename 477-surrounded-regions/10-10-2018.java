class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Solution {
    /*
     * @param board: board a 2D board containing 'X' and 'O'
     * @return: nothing
     */
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int n;
    int m;
    public void surroundedRegions(char[][] board) {
        // write your code here
        if (board.length == 0) {
            return;
        }
        n = board.length;
        m = board[0].length;
        if (m == 0) {
            return;
        }
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                bfs(q, visited, new Point(i, 0), board);
            }
            if (board[i][m - 1] == 'O') {
                bfs(q, visited, new Point(i, m - 1), board);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                bfs(q, visited, new Point(0, i), board);
            }
            if (board[n - 1][i] == 'O') {
                bfs(q, visited, new Point(n - 1, i), board);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
    void bfs(Queue<Point> q, boolean[][] visited, Point p, char[][] board) {
        q.add(p);
        visited[p.x][p.y] = true;
        while (!q.isEmpty()) {
            Point temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = temp.x + dx[i];
                int nextY = temp.y + dy[i];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                if (board[nextX][nextY] == 'O') {
                    visited[nextX][nextY] = true;
                    q.add(new Point(nextX, nextY));
                }
            }
        }
    }
}
