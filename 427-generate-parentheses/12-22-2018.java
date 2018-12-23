class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(n, n, "", res);
        return res;
    }
    void dfs(int left, int right, String str, List<String> res) {
        if (right == 0) {
            res.add(str);
            return;
        }
        if (left >= 1) {
            dfs(left - 1, right, str + "(", res);
        }
        if (right > left) {
            dfs(left, right - 1, str + ")", res);
        }
    }
}
