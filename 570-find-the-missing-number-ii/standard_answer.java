public class Solution {
    /**
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    private int theMissing = -1;
    public int findMissing2(int n, String str) {
        // write your code here
        boolean[] visited = new boolean[n + 1];
        dfs(n, str, 0, visited);
        return theMissing;
    }
    private void dfs(int n, String str, int start, boolean[] visited) {
        if (theMissing != -1) {
            return;
        }
        if (start == str.length()) { // only one sequence is right
            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    theMissing = i;
                    return;
                }
            }
            return;
        }
        if (str.charAt(start) == '0') {
            return;
        }
        for (int ch = 1; ch <= 2 && start + ch <= str.length(); ch++) {
            int num = Integer.parseInt(str.substring(start, start + ch));
            if (num > 0 && num <= n && !visited[num]) {
                visited[num] = true;
                dfs(n, str, start + ch, visited);
                visited[num] = false;
            }
        }
        return;
    }
}
