class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new LinkedList<>();
        dfs(1, n, k, list, res);
        return res;
    }
    void dfs(int start, int n, int k, List<Integer> list, List<List<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(i + 1, n, k - 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
