class Solution {
    public List<List<Integer>> getFactors(int n) {
        if (n < 2) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        helper(n, 2, new ArrayList<>(), res);
        return res;
    }
    void helper(int n, int start, List<Integer> list, List<List<Integer>> res) {
        if (n == 1) {
            if (list.size() >= 2) {
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                list.add(i);
                helper(n / i, i, list, res);
                list.remove(list.size() - 1);
            }
        }
        list.add(n);
        helper(1, n, list, res);
        list.remove(list.size() - 1);
    }
}
