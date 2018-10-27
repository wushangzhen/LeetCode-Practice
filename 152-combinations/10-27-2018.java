public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0) {
            return res;
        }
        dfs(1, new LinkedList<>(), res, n, k);
        return res;
    }
    void dfs(int start, List<Integer> list, List<List<Integer>> res, int n, int k) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(i + 1, list, res, n, k);
            list.remove(list.size() - 1);
        }
    }
}
