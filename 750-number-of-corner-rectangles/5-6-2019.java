class Solution {
    public int countCornerRectangles(int[][] grid) {
        Map<Integer, Integer> count = new HashMap<>();
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for (int[] row : grid) {
            for (int i = 0; i < m; i++) {
                if (row[i] == 1) {
                    for (int j = i + 1; j < m; j++) {
                        if (row[j] == 1) {
                            int pos = i * 200 + j;
                            ans += count.getOrDefault(pos, 0);
                            count.putIfAbsent(pos, 0);
                            count.put(pos, count.get(pos) + 1);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
