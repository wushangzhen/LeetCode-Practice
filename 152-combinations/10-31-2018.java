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
        helper(1, n, k, new LinkedList<>(), res);
        return res;
    }
    void helper(int start, int n, int k, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= n; i++) {
            list.add(i);
            helper(i + 1, n, k, list, res);
            list.remove(list.size() - 1);
        }
    }
}
