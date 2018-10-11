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
    public void surroundedRegions(char[][] board) {
        // write your code here
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        if (m == 0) {
            return;
        }
        Queue<Point> q = new LinkedList<>();
        List<Point> list = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    continue;
                }
                if (board[i][j] == 'X') {
                    continue;
                }
                if (!isBound(new Point(i, j), n, m) && board[i][j] == 'O') {
                    q.add(new Point(i, j));
                    visited[i][j] = true;
                    list.add(new Point(i, j));
                    while (!q.isEmpty()) {
                        Point point = q.poll();
                        if (isBound(point, n, m)) {
                            list.clear();
                            break;
                        }
                        for (int k = 0; k < 4; k++) {
                            int nextX = point.x + dx[k];
                            int nextY = point.y + dy[k];
                            if (nextX < 0 || nextX >= n 
                                || nextY < 0 || nextY >= m) {
                                continue;
                            }
                            if (visited[nextX][nextY]) {
                               continue; 
                            }
                            if (board[nextX][nextY] == 'O') {
                                visited[nextX][nextY] = true;
                                q.add(new Point(nextX, nextY));
                                list.add(new Point(nextX, nextY));
                            }
                        }
                    }
                    if (!list.isEmpty()) {
                        for (Point p : list) {
                            board[p.x][p.y] = 'X';
                        }
                        list.clear();
                    }
                }
            }
        }
    }
    boolean isBound(Point p, int n, int m) {
        if (p.x == 0 || p.x == n - 1 || p.y == 0 || p.y == m - 1) {
            return true;
        }
        return false;
    }
}
