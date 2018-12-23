class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 2) {
            return res;
        }
        dfs(2, n, new LinkedList<Integer>(), res);
        return res;
    }
    void dfs(int x, int n, List<Integer> list, List<List<Integer>> res) {
        if (n == 1 && list.size() > 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = x; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                dfs(i, n / i, list, res);
                list.remove(list.size() - 1);
            }
        }
        if (n >= x) {
            list.add(n);
            dfs(n, 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
