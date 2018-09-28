class Cell {
    public int x, y, height;
    Cell(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }
}
class CellComparator implements Comparator<Cell> {
    public int compare(Cell left, Cell right) {
        return left.height - right.height;
    }
}
public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int trapRainWater(int[][] heights) {
        // write your code here
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Queue<Cell> minHeap = new PriorityQueue<>(new CellComparator());
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            minHeap.offer(new Cell(i, 0, heights[i][0]));
            minHeap.offer(new Cell(i, m - 1, heights[i][m - 1]));
            visited[i][0] = true;
            visited[i][m - 1] = true;
        }
        for (int i = 0; i < m; i++) {
            minHeap.offer(new Cell(0, i, heights[0][i]));
            minHeap.offer(new Cell(n - 1, i, heights[n - 1][i]));
            visited[0][i] = true;
            visited[n - 1][i] = true;
        }
        int water = 0;
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cell.x + dx[i];
                int ny = cell.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                minHeap.offer(new Cell(nx, ny, Math.max(cell.height, heights[nx][ny])));
                water = water + Math.max(0, cell.height - heights[nx][ny]);
            }
        }
        return water;
    }
}
