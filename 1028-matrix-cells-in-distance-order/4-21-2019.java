class Solution {
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R * C][2];
        for (int i = 0; i < R * C; i++) {
                res[i][0] = i / C;
                res[i][1] = i % C;
        }
        Arrays.sort(res, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int dist1 = Math.abs(a[0] - r0) + Math.abs(a[1] - c0);
                int dist2 = Math.abs(b[0] - r0) + Math.abs(b[1] - c0);
                return dist1 - dist2;
            }
        });
        return res;
    }
}
