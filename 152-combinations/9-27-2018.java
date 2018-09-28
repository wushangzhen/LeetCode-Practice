public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n == 0 || k == 0) {
            return result;
        }
        List<Integer> path = new ArrayList<Integer>();
        dfs(1, n, k, path, result);
        return result;
    }
    void dfs(int start, int n, int k, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.add(i);
            dfs(i + 1, n, k, path, result);
            path.remove(path.size() - 1);
        }
    }
}
