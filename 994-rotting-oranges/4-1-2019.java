class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                } else if (grid[i][j] == 2) {
                    int[] temp = new int[]{i, j};
                    q.add(temp);
                }
            }
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        if (count == 0 && q.isEmpty()) {
            return 0;
        }
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (count == 0) {
                return res;
            }
            for (int i = 0; i < size; i++) {
                int[] temp = q.poll();
                if (count == 0) {
                    return res + 1;
                }
                for (int j = 0; j < 4; j++) {
                    int x = temp[0] + dx[j];
                    int y = temp[1] + dy[j];
                    if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    } 
                    q.add(new int[]{x, y});
                    grid[x][y] = 2;
                    count--;
                }
            }
            res++;
        }
        return -1;
    }
}
