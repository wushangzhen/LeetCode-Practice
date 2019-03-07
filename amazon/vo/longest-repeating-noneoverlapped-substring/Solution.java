class Solution {
    public static String find(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];
        // dp[i][j] longest substrings ending with i and j 
        int index = 0;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && (j - i) > dp[i - 1][j - 1]) { // in case of overlapping
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > max) {
                    index = i;
                    max = dp[i][j];
                }
            }
        }
        return str.substring(index - max, index);
    }
    public static void main(String[] args) {
        System.out.println(Solution.find("geeksforgeeks"));
        
    }
}
