class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        Map<String, Integer> map0 = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        for (String str : strs) {
            int count = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    count++;
                }
            }
            map0.put(str, count);
            map1.put(str, str.length() - count);
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            for (int i = m; i >= map0.get(str); i--) {
                for (int j = n; j >= map1.get(str); j--) {
                    dp[i][j] = Math.max(1 + dp[i - map0.get(str)][j - map1.get(str)], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
}
