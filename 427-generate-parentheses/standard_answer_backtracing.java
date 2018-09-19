public class Solution {
    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        // write your code here
        List<String> result = new ArrayList<String> ();
        String str = "";
        if (n <= 0) {
            return result;
        }
        helper(str, n, n, result);
        return result;
    }
    void helper(String str, int left, int right, List<String> result) {
        if (right == 0 && left == 0) {
           result.add(str);
           return;
        }
        if (left > 0) {
            str += "(";
            helper(str, left - 1, right, result);
            str = str.substring(0, str.length() - 1);
        }
        if (right > 0 && left < right) {
            str += ")";
            helper(str, left, right - 1, result);
            str = str.substring(0, str.length() - 1);
        }
    }
}
