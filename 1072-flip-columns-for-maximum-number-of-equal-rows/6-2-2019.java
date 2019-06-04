class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                sb1.append(matrix[i][j]);
                sb2.append(1 - matrix[i][j]);
            }
            String s1 = sb1.toString();
            String s2 = sb2.toString();
            map.put(s1, map.getOrDefault(s1, 0) + 1);
            map.put(s2, map.getOrDefault(s2, 0) + 1);
        }
        int max = 0;
        for (int a : map.values()) {
            max = Math.max(a, max);
        }
        return max;
    }
}
