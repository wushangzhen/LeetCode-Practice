class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0) {
            return;
        }
        int n = rooms.length;
        int m = rooms[0].length;
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rooms[i][j] == 0) {
                    q.add(new Point(i, j));
                }
            }
        }
        fill(q, rooms);
    }
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public void fill(Queue<Point> q, int[][] rooms) {
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                Point p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= rooms.length || ny >= rooms[0].length || rooms[nx][ny] != Integer.MAX_VALUE) {
                        continue;
                    }
                    if (count < rooms[nx][ny]) {
                        rooms[nx][ny] = count;    
                    }
                    q.add(new Point(nx, ny));
                }
            }
        }
    }
    
}
