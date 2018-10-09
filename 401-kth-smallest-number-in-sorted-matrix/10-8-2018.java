class Pair {
    int x;
    int y;
    int value;
    Pair(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
}
class PairComparator implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return a.value - b.value;
    }
}
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        Queue<Pair> pq = new PriorityQueue<Pair>(new PairComparator());
        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] visited = new boolean[n][m];
        pq.add(new Pair(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for (int i = 0; i < k - 1; i++) {
            Pair pair = pq.poll();
            for (int j = 0; j < 2; j++) {
                int nextX = pair.x + dx[j];
                int nextY = pair.y + dy[j];
                if (nextX >= n || nextY >= m || visited[nextX][nextY]) {
                    continue;
                }
                pq.add(new Pair(nextX, nextY, matrix[nextX][nextY]));
                visited[nextX][nextY] = true;
            }
        }
        return pq.peek().value;
    }
}
