class Pair {
    public int x;
    public int y;
    public int sum;
    Pair(int x, int y, int sum) {
        this.x = x;
        this.y = y;
        this.sum = sum;
    }
}
class IntComparator implements Comparator<Pair> {
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
        Queue<Pair> minHeap = new PriorityQueue<Pair>(k, new IntComparator());
        int n = A.length;
        int m = B.length;
        boolean[][] hash = new boolean[n][m];
        minHeap.add(new Pair(0, 0, A[0] + B[0]));
        int[] deltaA = {0, 1};
        int[] deltaB = {1, 0};
        for (int i = 0; i < k - 1; i++) {
            Pair cur = minHeap.poll();
            for (int j = 0; j < 2; j++) {
                int nextX = cur.x + deltaA[j];
                int nextY = cur.y + deltaB[j];
                Pair nextPair = new Pair(nextX, nextY, 0);
                if (nextX < A.length && nextY < B.length && !hash[nextX][nextY]) {
                    hash[nextX][nextY] = true;
                    nextPair.sum = A[nextX] + B[nextY];
                    minHeap.add(nextPair);
                }
            }
        }
        return minHeap.peek().sum;
    }
}
