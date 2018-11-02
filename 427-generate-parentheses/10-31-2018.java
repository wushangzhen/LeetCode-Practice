public class Solution {
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        // write your code here
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        helper("", n, n, res);
        return res;
    }
    void helper(String str, int left, int right, List<String> res) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            helper(str + "(", left - 1, right, res);
        }
        helper(str + ")", left, right - 1, res);
    }
}
