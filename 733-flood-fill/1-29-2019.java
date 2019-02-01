class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }
        if (image[sr][sc] == newColor) return image;
        int n = image.length;
        int m = image[0].length;
        if (m == 0) {
            return image;
        }
        int oldColor = image[sr][sc];
        dfs(sr, sc, image, newColor, oldColor);
        return image;
    }
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    void dfs(int sr, int sc, int[][] image, int newColor, int oldColor) {
        image[sr][sc] = newColor;
        for (int i = 0; i < 4; i++) {
            int nx = sr + dx[i];
            int ny = sc + dy[i];
            if (nx < 0 || nx >= image.length || ny < 0 || ny >= image[0].length || image[nx][ny] != oldColor) {
                continue;
            }
            dfs(nx, ny, image, newColor, oldColor);
        }
    }
}
