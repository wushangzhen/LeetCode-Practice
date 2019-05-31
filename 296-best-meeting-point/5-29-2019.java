class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        return getMin(rows) + getMin(cols);
    }
    int getMin(List<Integer> list) {
        Collections.sort(list);
        int i = 0;
        int j = list.size() - 1;
        int res = 0;
        while (i < j) {
            res += list.get(j--) - list.get(i++);
        }
        return res;
    }
}
