class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        int[][] dists = new int[n][m];
        for (int[] dist : dists) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        // Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
        //     public int compare(int[] temp1, int[] temp2) {
        //         return temp1[2] - temp2[2];
        //     }
        // });
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start[0], start[1], 0});
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if (dists[temp[0]][temp[1]] > temp[2]) {
                dists[temp[0]][temp[1]] = temp[2];
            } else {
                continue;
            } // continue updates the dist
            for (int i = 0; i < 4; i++) {
                int count = 0;
                int x = temp[0] + dx[i];
                int y = temp[1] + dy[i];
                count++;
                while (x >= 0 && x < n && y >= 0 && y < m && maze[x][y] == 0) {
                    x += dx[i];
                    y += dy[i];
                    count++;
                }
                q.add(new int[]{x - dx[i], y - dy[i], temp[2] + count - 1});
            }
        }
        return dists[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dists[destination[0]][destination[1]];
    }
}
