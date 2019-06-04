class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] preSum = new int[n + 1][m];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                preSum[i][j] = preSum[i - 1][j] + matrix[i - 1][j];
            }
        }
        int tot = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int[] temp = new int[m];
                for (int k = 0; k < m; k++) {
                    temp[k] = preSum[i + 1][k] - preSum[j][k];
                }
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += temp[k];
                    if (map.containsKey(sum - target)) {
                        tot += map.get(sum - target);
                    }
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return tot;
    }
}
