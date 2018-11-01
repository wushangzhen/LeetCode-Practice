public class Solution {
    /**
     * @param n: An integer
     * @return: a list of combination
     */
    public List<List<Integer>> getFactors(int n) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (n == 1 || n == 0) {
            return res;
        }
        helper(2, n, new LinkedList<>(), res);
        return res;
    }
    void helper(int num, int n, List<Integer> list, List<List<Integer>> res) {
        if (n == 1 && list.size() > 1) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = num; i <= Math.sqrt(n); i++) { // pruning 
            if (n % i == 0) {
                list.add(i);
                helper(i, n / i, list, res);
                list.remove(list.size() - 1);
            }
        }
        if (n >= num) { // deal with the another solution
            list.add(n);
            helper(n, 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}
