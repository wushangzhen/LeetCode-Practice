class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] pattern = new int[10][10];
        //规范
        pattern[1][3] = pattern[3][1] = 2;
        pattern[1][7] = pattern[7][1] = 4;
        pattern[1][9] = pattern[9][1] = 5;
        pattern[3][9] = pattern[9][3] = 6;
        pattern[3][7] = pattern[7][3] = 5;
        pattern[9][7] = pattern[7][9] = 8;
        pattern[4][6] = pattern[6][4] = 5;
        pattern[2][8] = pattern[8][2] = 5;
        int res = 0;
        boolean[] visited = new boolean[10];
        res += helper(1, 1, 0, m, n, pattern, visited) * 4;
        res += helper(4, 1, 0, m, n, pattern, visited) * 4;
        res += helper(5, 1, 0, m, n, pattern, visited);
        return res;
    }
    int helper(int x, int len, int res, int m, int n, int[][] pattern, boolean[]visited) {
        if (len >= m) {
            res++;
        }
        len++;
        if (len > n) {
            return res;
        }
        visited[x] = true;
        for (int i = 1; i <= 9; i++) {
            int jump = pattern[x][i];
            if ((jump == 0 || visited[jump]) && !visited[i]) {
                res = helper(i, len, res, m, n, pattern, visited);
            }
        }
        visited[x] = false;
        return res;
    }
}
