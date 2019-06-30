class Solution {
    public int maximumMinimumPath(int[][] A) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->(b[2] - a[2]));
        int n = A.length;
        int m = A[0].length;
        int[][] vv = new int[n][m];
        for (int[] v : vv) {
            Arrays.fill(v, -1);
        }
        pq.add(new int[]{0, 0, A[0][0]});
        vv[0][0] = A[0][0];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || vv[nx][ny] != -1) {
                    continue;
                }
                vv[nx][ny] = Math.min(p[2], A[nx][ny]);
                if (nx == n - 1 && ny == m - 1) {
                    return vv[nx][ny];
                }
                pq.add(new int[]{nx, ny, vv[nx][ny]});
            }
        }
        return -1;
    }
}
