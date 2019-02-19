class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        helper(n, n, "", res);
        return res;
    }
    public void helper(int left, int right, String str, List<String> res) {
        if (left > right) {
            return;
        }
        if (right == 0) {
            res.add(str);
            return;
        }
        if (left > 0) {
            helper(left - 1, right, str + "(", res);
        } 
        if (right > 0) {
            helper(left, right - 1, str + ")", res);
        }
    }
}
