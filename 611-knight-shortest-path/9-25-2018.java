/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        if (grid[source.x][source.y] || grid[destination.x][destination.y]) {
            return -1;
        } 
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        queue.add(source);
        grid[source.x][source.y] = true;
        int count = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            for (int k = 0; k < size; k++) {
                Point point = queue.poll();
                if (point.x == destination.x && point.y == destination.y) {
                    return count;
                }
                for (int i = 0; i < 8; i++) {
                    int nextX = point.x + dx[i];
                    int nextY = point.y + dy[i];
                    if (nextX >= 0 && nextY >= 0 && 
                        nextX < grid.length && nextY < grid[0].length
                        && !grid[nextX][nextY]) {
                        queue.add(new Point(nextX, nextY));
                        grid[nextX][nextY] = true;
                    }
                }
            }
        }
        return -1;
    }
}
