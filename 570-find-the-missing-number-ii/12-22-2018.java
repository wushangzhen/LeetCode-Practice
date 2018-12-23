public class Solution {
    /**
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    int res = -1;
    public int findMissing2(int n, String str) {
        // write your code here
        if (n <= 0) {
            return -1;
        }
        int[] memo = new int[n];
        dfs(n, str, memo);
        return res;
    }
    void dfs(int n, String str, int[] memo) {
        if (str.length() == 0) {
            if (res != -1) {
                return;
            }
            int count = 0; // special test case
            for (int i = 0; i < n; i++) {
                if (memo[i] != 1) {
                    res = i + 1;
                    count++;
                }
            }
            if (count > 2) {
                res = -1;
            }
            return;
        }
        int index = str.charAt(0) - '0';
        if (index != 0 && index - 1 < n && memo[index - 1] == 0) {
            memo[index - 1] = 1;
            dfs(n, str.substring(1), memo);
            memo[index - 1] = 0;
        }
        if (str.length() > 1) {
            String temp = str.substring(0, 2);
            if (str.charAt(0) - '0' == 0 || 
                Integer.parseInt(temp) > n || memo[Integer.parseInt(temp) - 1] == 1) {
                return;
            }
            memo[Integer.parseInt(temp) - 1] = 1;
            dfs(n, str.substring(2), memo);
            memo[Integer.parseInt(temp) - 1] = 0;
        }
    }
}
