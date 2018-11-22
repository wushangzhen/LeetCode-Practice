class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int minArea(char[][] image, int x, int y) {
        int n = image.length;
        int m = image[0].length;
        int leftMax = x;
        int rightMax = x;
        int topMax = y;
        int downMax = y;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};
        Queue<Point> q = new LinkedList<>();
        Point init = new Point(x, y);
        q.add(init);
        while (!q.isEmpty()) {
            Point temp = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = temp.x + dx[i];
                int nextY = temp.y + dy[i];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }
                if (image[nextX][nextY] == '1') {
                    image[nextX][nextY] = '0';
                    q.add(new Point(nextX, nextY));
                    leftMax = Math.min(leftMax, nextX);
                    rightMax = Math.max(rightMax, nextX);
                    topMax = Math.min(topMax, nextY);
                    downMax = Math.max(downMax, nextY);
                }
            }
        }
        return (rightMax - leftMax + 1) * (downMax - topMax + 1);
    }
}
