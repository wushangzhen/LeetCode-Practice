public class Solution {
    /**
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    int v = 0;
    public int findMissing2(int n, String str) {
        // write your code here
        if (n == 0) {
            return -1;
        }
        int[] memo = new int[n];
        helper(0, str, memo, n);
        return v;
        
    }
    void helper(int start, String str, int[] memo, int n) {
        if (start == str.length()) {
            for (int i = 0; i < n; i++) {
                if (memo[i] != 1) {
                    v = i + 1;
                }
            }
            return;
        }
        if (str.charAt(start) - '0' <= (n / 10) && str.charAt(start) != '0') {
            String s = str.substring(start, start + 2);
            int value = Integer.parseInt(s);
            if (value <= n) {
                if (memo[value - 1] == 0) {
                    memo[value - 1] = 1;
                    helper(start + 2, str, memo, n);
                    memo[value - 1] = 0;
                } 
            }
        }
        int value = str.charAt(start) - '0';
        if (value != 0 && memo[value - 1] == 0) {
            memo[value - 1] = 1;
            helper(start + 1, str, memo, n);
            memo[value - 1] = 0;
        }
    }
}
