class Pair {
    public int x;
    public int y;
    public int val;
    public Pair(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
class PairCompartor implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.val - b.val;
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
        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] hash = new boolean[n][m];
        Queue<Pair> minHeap = new PriorityQueue<Pair>(k, new PairCompartor());
        minHeap.add(new Pair(0, 0, matrix[0][0]));
        for (int i = 0; i < k - 1; i++) {
            Pair cur = minHeap.poll();
            for (int j = 0; j < 2; j++) {
                int nextX = cur.x + dx[j];
                int nextY= cur.y + dy[j];
                Pair nextPair = new Pair(nextX, nextY, 0);
                if (nextX < n && nextY < m && !hash[nextX][nextY]) {
                    hash[nextX][nextY] = true;
                    nextPair.val = matrix[nextX][nextY];
                    minHeap.add(nextPair);
                }
            }
        }
        return minHeap.peek().val;
    }
}
