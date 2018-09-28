class Pair {
    int x;
    int y;
    int val;
    Pair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class PairComparator implements Comparator<Pair> {
    public int compare(Pair left, Pair right) {
        return left.val - right.val;
    }
}
public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @param k: An integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if (matrix == null || matrix.length == 0 || k == 0) {
            return -1;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        if (m == 0) {
            return -1;
        }
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        Queue<Pair> minHeap = new PriorityQueue<Pair>(new PairComparator());
        boolean[][] visited = new boolean[n][m];
        minHeap.offer(new Pair(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Pair pair = minHeap.poll();
            for (int j = 0; j < 2; j++) {
                int nx = pair.x + dx[j];
                int ny = pair.y + dy[j];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                minHeap.offer(new Pair(nx, ny, matrix[nx][ny]));
                visited[nx][ny] = true;
            }
        }
        return minHeap.peek().val;
    }
}
