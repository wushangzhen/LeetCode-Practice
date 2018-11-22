class Point {
    int x;
    int y;
    int value;
    public Point(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        Queue<Point> q = new PriorityQueue<>(new Comparator<Point>() {
           public int compare(Point a, Point b) {
               return a.value - b.value;
           } 
        });
        boolean[][] visited = new boolean[n][n];
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        q.add(new Point(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Point point = q.poll();
            for (int j = 0; j < 2; j++) {
                int nextX = point.x + dx[j];
                int nextY = point.y + dy[j];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || visited[nextX][nextY]) {
                    continue;
                }
                q.add(new Point(nextX, nextY, matrix[nextX][nextY]));
                visited[nextX][nextY] = true;
            }
        }
        return q.peek().value;
    }
}
