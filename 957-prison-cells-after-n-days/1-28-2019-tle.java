class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (cells == null || cells.length == 0 || N == 0) {
            return cells;
        }
        int n = cells.length;
        boolean[] changeTo1 = new boolean[n];
        for (int i = 0; i < N; i++) {
            Arrays.fill(changeTo1, false);
            for (int j = 1; j + 1 < cells.length; j++) {
                if ((cells[j - 1] == 1 && cells[j + 1] == 1)
                   || (cells[j - 1] == 0 && cells[j + 1] == 0)) {
                    changeTo1[j] = true;
                }
            }
            for (int j = 0; j < n; j++) {
                if (changeTo1[j]) {
                    cells[j] = 1;
                } else {
                    cells[j] = 0;
                }
            }
        }
        return cells;
    }
}
