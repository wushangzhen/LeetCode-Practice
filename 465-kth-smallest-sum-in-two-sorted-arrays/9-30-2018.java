class Pair {
    int x;
    int y;
    int sum;
    Pair(int x, int y, int sum) {
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
}
class PairComparator implements Comparator<Pair> {
    public int compare(Pair left, Pair right) {
        return left.sum - right.sum;
    }
}
public class Solution {
    /**
     * @param A: an integer arrays sorted in ascending order
     * @param B: an integer arrays sorted in ascending order
     * @param k: An integer
     * @return: An integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        if ((A == null || A.length == 0) && (B == null || B.length == 0)) {
            return 0;
        }
        if (A == null || A.length == 0) {
            return B[k - 1];
        }
        if (B == null || B.length == 0) {
            return A[k - 1];
        }
        int[] dx = {1, 0};
        int[] dy = {0, 1};
        int n = A.length;
        int m = B.length;
        Queue<Pair> heap = new PriorityQueue<Pair>(k, new PairComparator());
        boolean[][] hash = new boolean[n][m];
        heap.add(new Pair(0, 0, A[0] + B[0]));
        hash[0][0] = true;
        for (int j = 0; j < k - 1; j++) {
            Pair pair = heap.poll();
            for (int i = 0; i < 2; i++) {
                int nextX = pair.x + dx[i];
                int nextY = pair.y + dy[i];
                if (nextX < A.length && nextY < B.length && !hash[nextX][nextY]) {
                    heap.add(new Pair(nextX, nextY, A[nextX] + B[nextY]));
                    hash[nextX][nextY] = true;
                }
            }
            
        }
        return heap.peek().sum;
    }
}
