class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int row = m;
        int col = n;
        for (int[] op : ops) {
            row = Math.min(op[0], row);
            col = Math.min(op[1], col);
        }
        return row * col;
    }
}
